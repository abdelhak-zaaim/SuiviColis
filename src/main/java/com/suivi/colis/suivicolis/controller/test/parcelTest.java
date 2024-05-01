/*
 * **
 *  * @project : SuiviColis
 *  * @created : 30/04/2024, 19:15
 *  * @modified : 30/04/2024, 19:15
 *  * @description : This file is part of the SuiviColis project.
 *  * @license : MIT License
 * **
 */

package com.suivi.colis.suivicolis.controller.test;

import com.suivi.colis.suivicolis.entity.Address;
import com.suivi.colis.suivicolis.entity.Customer;
import com.suivi.colis.suivicolis.entity.DeliveryAddress;
import com.suivi.colis.suivicolis.entity.Parcel;
import com.suivi.colis.suivicolis.model.enums.ParcelStatus;
import com.suivi.colis.suivicolis.service.AddressService;
import com.suivi.colis.suivicolis.service.CustomerService;
import com.suivi.colis.suivicolis.service.DeliveryAddressService;
import com.suivi.colis.suivicolis.service.ParcelService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class parcelTest {

   AddressService addressService;
   DeliveryAddressService deliveryAddressService;
   CustomerService customerService;
   ParcelService parcelService;

   public parcelTest(AddressService addressService, DeliveryAddressService deliveryAddressService, CustomerService customerService, ParcelService parcelService) {
      this.addressService = addressService;
      this.deliveryAddressService = deliveryAddressService;
      this.customerService = customerService;
      this.parcelService = parcelService;
   }

   @GetMapping("/test/parcel/add")
   public ResponseEntity<Parcel> addParcel() {
      String mySecret = System.getenv("EMAIL");
      System.out.println(mySecret+ " *******");
      Address address = new Address();
      address.setCity("fes");
      address.setCountry("Morocco");
      address.setState("Some State");
      address.setStreet("marja");
      address.setZip("20000");
      address = addressService.addAddress(address);

      DeliveryAddress deliveryAddress = new DeliveryAddress();
      deliveryAddress.setAddress("fes marja");
      deliveryAddress.setCity("fes");
      deliveryAddress.setCountry("Morocco");
      deliveryAddress.setState("fes maknes");
      deliveryAddress.setPostalCode("20000");
      deliveryAddress.setContactNumber("123456789");
      deliveryAddress.setContactName("abdelhak");

      DeliveryAddress deliveryAddress1 = deliveryAddressService.addDeliveryAddress(deliveryAddress);


      DeliveryAddress deliveryAddress2 = new DeliveryAddress();
      deliveryAddress2.setAddress("rue 1"); // Add this line
      deliveryAddress2.setCity("casablanca");
      deliveryAddress2.setCountry("Morocco");
      deliveryAddress2.setState("casa settat");
      deliveryAddress2.setPostalCode("30000");
      deliveryAddress2.setContactNumber("0675757677");
      deliveryAddress2.setContactName("abdelhak");
      deliveryAddress2 = deliveryAddressService.addDeliveryAddress(deliveryAddress2);


      Parcel parcel = new Parcel();
      parcel.setStatus(ParcelStatus.IN_TRANSIT);
      parcel.setWeight(2);
      parcel.setHeight(3);
      parcel.setWeight(4);
      parcel.setPickupAddress(deliveryAddress2);
      Customer customer = customerService.getCustomer(1L);
      parcel.setSenderCustomer(customer);
      parcel.setReceiverAddress(deliveryAddress1);


      Parcel p = parcelService.addParcel(parcel);
      return ResponseEntity.ok(p);
   }
}