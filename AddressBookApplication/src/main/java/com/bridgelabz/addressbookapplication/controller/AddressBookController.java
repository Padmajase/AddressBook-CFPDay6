package com.bridgelabz.addressbookapplication.controller;

import com.bridgelabz.addressbookapplication.dto.AddressBookDTO;
import com.bridgelabz.addressbookapplication.dto.ResponseDTO;
import com.bridgelabz.addressbookapplication.model.AddressBookData;
import com.bridgelabz.addressbookapplication.services.IAddressBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employeepayrollservice")
public class AddressBookController {

    @Autowired
    private IAddressBook addressBookService;

    // curl localhost:8080/employeepayrollservice -w "\n"
    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<AddressBookData> personDataList = null;
        personDataList = addressBookService.getAddressBookData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Successfull", personDataList);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    // curl localhost:8080/employeepayrollservice/get/{empId} -w "\n"
    @GetMapping("/get/{personId}")
    public ResponseEntity<ResponseDTO> getAddressBookDataById(@PathVariable("personId") long personId) {
//        List<AddressBookData> personDataList = null;
        Optional <AddressBookData> personData = null;
        personData = addressBookService.getAddressBookDataById(personId);
        ResponseDTO respDTO = new ResponseDTO("Get Call For ID Successfull ", personData);
        return  new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    // curl -X POST -H "Content-Type: application/json" -d
    // '{"name": "neha","salary":3000}' "http://localhost:8080/employeepayrollservice/create" -w "\n"
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(
                            @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData personData = null;
        personData = addressBookService.createAddressBookData(addressBookDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successfully", personData);
        return  new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    //curl -X PUT -H "Content-Type: application/json" -d '{"name": "neha","salary": 3000}'
    //"http://localhost:8080/employeepayrollservice/update" -w "\n"
    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("personId") long personId,
            @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData personData = null;
        personData = addressBookService.updateAddressBookData(personId, addressBookDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll Data Successfully", personData);
        return  new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    //curl -X DELETE -H "Content-Type: application/json"
    //localhost:8080/employeepayrollservice/delete/1 -w "\n"
    @DeleteMapping("delete/{personId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("personId")long personId) {
        addressBookService.deleteAddressBookData(personId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted Id : " +personId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}
