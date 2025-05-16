package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AddressBookService {
    private Map<Integer, AddressBookData> addressBookMap = new HashMap<>();
    private AtomicInteger counter = new AtomicInteger();

    public List<AddressBookData> getAllContacts() {
        return new ArrayList<>(addressBookMap.values());
    }

    public AddressBookData getContactById(int id) {
        return addressBookMap.get(id);
    }

    public AddressBookData createContact(AddressBookDTO dto) {
        AddressBookData data = new AddressBookData();
        int id = counter.incrementAndGet();
        data.setId(id);
        data.setName(dto.getName());
        data.setAddress(dto.getAddress());
        data.setPhoneNumber(dto.getPhoneNumber());
        addressBookMap.put(id, data);
        return data;
    }

    public AddressBookData updateContact(int id, AddressBookDTO dto) {
        AddressBookData data = addressBookMap.get(id);
        if (data != null) {
            data.setName(dto.getName());
            data.setAddress(dto.getAddress());
            data.setPhoneNumber(dto.getPhoneNumber());
        }
        return data;
    }

    public void deleteContact(int id) {
        addressBookMap.remove(id);
    }
}
