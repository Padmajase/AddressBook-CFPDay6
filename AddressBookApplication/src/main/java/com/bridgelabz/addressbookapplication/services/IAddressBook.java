package com.bridgelabz.addressbookapplication.services;

import com.bridgelabz.addressbookapplication.dto.AddressBookDTO;
import com.bridgelabz.addressbookapplication.model.AddressBookData;

import java.util.List;
import java.util.Optional;


public interface IAddressBook {

    List<AddressBookData> getAddressBookData();

    Optional<AddressBookData> getAddressBookDataById(long personId);

    AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);

    AddressBookData updateAddressBookData(long personId, AddressBookDTO addressBookDTO);

    void deleteAddressBookData(long personId);
}
