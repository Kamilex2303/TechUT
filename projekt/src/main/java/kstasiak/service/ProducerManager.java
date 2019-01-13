package kstasiak.service;
import kstasiak.domain.Address;
import kstasiak.domain.Producer;

import java.util.List;

public interface ProducerManager {
	
	// Producer
	void addProducer(Producer producer);
    List<Producer> getAllProducers();
    Producer findById(long id);
    void updateProducer(Producer producer);
    void deleteProducer(Producer producer);
    
    // Relations
    void assignPen(Long penId, Long producerId);
    void assignAddress(Long addressId, Long producerId);
    void deleteAddress(Long addressId, Long producerId);
    Producer findByName(String name);
    List<Address> getProducerAddresses(Producer producer);
}
