package com.bridgelabz.addressbookapplication.services;

import com.bridgelabz.addressbookapplication.dto.AddressBookDTO;
import com.bridgelabz.addressbookapplication.model.AddressBookData;
import com.bridgelabz.addressbookapplication.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements IAddressBook {

//    List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
    @Autowired
    private AddressBookRepository addressBookRepository;

   @Override
    public List<AddressBookData> getAddressBookData() {

       return addressBookRepository.findAll();
    }

    @Override
    public Optional<AddressBookData> getAddressBookDataById(long personId) {
        return addressBookRepository.findById(personId);
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(addressBookRepository.findAll().size() +1, addressBookDTO);
        addressBookRepository.save(addressBookData);
        return addressBookData;
    }

    @Override
    public void deleteAddressBookData(long empId) {
        addressBookRepository.deleteById(empId);
    }

    @Override
    public AddressBookData updateAddressBookData(long personId, AddressBookDTO addressBookDTO) {
       List<AddressBookData> addressBookDataList = this.getAddressBookData();
        for (AddressBookData personData : addressBookDataList ) {
            if(personData.getPersonId() == personId) {
                personData.setName(addressBookDTO.name);
                personData.setphoneNo(addressBookDTO.phoneNo);
                return personData;
            }
        }
        return null;
    }
}
