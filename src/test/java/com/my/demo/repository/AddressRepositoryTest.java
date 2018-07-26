package com.my.demo.repository;

import com.my.demo.configuration.Entry;
import com.my.demo.entity.Address;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Entry.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddressRepositoryTest {
	@Autowired
	private AddressRepository addressRepository;

	@Test
	public void testSave() {
		Address address = new Address();
		address.setContent("火星");
		address.setInsertTime(new Date());
		address.setIsDelete(false);
		addressRepository.save(address);
	}
	
	@Test
	public void testDel() {
		Address address = new Address();
		address.setAddressId(1);
		addressRepository.delete(address);
	}
}
