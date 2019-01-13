package kstasiak;

import kstasiak.domain.Address;
import kstasiak.domain.Producer;
import kstasiak.service.AddressManager;
import kstasiak.service.ProducerManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/beans.xml"})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class ProducerTest {

	@Autowired
	ProducerManager pm;
	
	@Autowired
	AddressManager am;
	
    @Test
    public void addProducerCheck() {
        Producer p = new Producer("Parker");

        pm.addProducer(p);

        Producer finded = pm.findById(p.getId());

        assertEquals(p.getId(), finded.getId());
    }
    
    @Test
    public void findProducerByNameCheck() {
    	Producer p = new Producer("Parker");
        pm.addProducer(p);

        String name = p.getName();

        Producer finded = pm.findByName(name);

        assertEquals(finded.getId(), p.getId());
    }
    
    @Test 
    public void producerAndAddressesCheck() {
    	Producer p = new Producer("Parker");
    	Address a1 = new Address("Testowa", "3/12", "80-126", "Gdansk");
    	Address a2 = new Address("Próbna", "10", "80-126", "Gdansk");
    	
    	pm.addProducer(p);

    	//Poczatkowy rozmiar listy adresów
    	int beginningSize = pm.getProducerAddresses(p).size();
    	
    	am.addAddress(a1);
    	am.addAddress(a2);
    	
    	// Dodanie 2 adresów
    	pm.assignAddress(a1.getId(), p.getId());
    	pm.assignAddress(a2.getId(), p.getId());

    	//Sprawdzenie rozmiaru listy po dodaniu adresów
    	int afterAssignedSize = pm.getProducerAddresses(p).size();
    	
    	assertEquals(beginningSize + 2, afterAssignedSize);
    	
    	// Usunięcie adresu
    	pm.deleteAddress(a2.getId(), p.getId());

    	//Rozmiar listy po usunieciu
    	int afterFirstDeleteSize = pm.getProducerAddresses(p).size();
    	
    	assertEquals(beginningSize + 1, afterFirstDeleteSize);

    	//Usunięcie rozmiaru
    	pm.deleteAddress(a1.getId(), p.getId());

    	//Rozmiar listy po usunięciu
    	int afterWholeDeleteSize = pm.getProducerAddresses(p).size();
    	
    	assertEquals(beginningSize, afterWholeDeleteSize);
    }
}
