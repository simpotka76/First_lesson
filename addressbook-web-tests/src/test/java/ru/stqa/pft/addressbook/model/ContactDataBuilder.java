package ru.stqa.pft.addressbook.model;

import java.time.LocalDate;
import java.util.Set;


public class ContactDataBuilder {

  private final ContactData contactData = new ContactData();

  public ContactDataBuilder withAllEmails(String allEmails){
    contactData.setAllEmails(allEmails);
    return this;
  }

  public ContactDataBuilder withAllPhones(String allPhones){
    contactData.setAllPhones(allPhones);
    return this;
  }

  public ContactDataBuilder creation(Boolean creation) {
    contactData.setCreation(creation);
    return this;
  }

  public ContactDataBuilder title(String title) {
    contactData.setTitle(title);
    return this;
  }

  public ContactDataBuilder company(String company) {
    contactData.setCompany(company);
    return this;
  }

  public ContactDataBuilder companyAddress(String companyAddress) {
    contactData.setCompanyAddress(companyAddress);
    return this;
  }

  public ContactDataBuilder email1(String email1) {
    contactData.setEmail1(email1);
    return this;
  }

  public ContactDataBuilder email2(String email2) {
    contactData.setEmail2(email2);
    return this;
  }

  public ContactDataBuilder email3(String email3) {
    contactData.setEmail3(email3);
    return this;

  }

  public ContactDataBuilder firstname(String firstname) {
    contactData.setFirstname(firstname);
    return this;
  }

  public ContactDataBuilder middleName(String middleName) {
    contactData.setMiddleName(middleName);
    return this;
  }

  public ContactDataBuilder lastname(String lastname) {
    contactData.setLastname(lastname);
    return this;
  }

  public ContactDataBuilder nickname(String nickname) {
    contactData.setNickname(nickname);
    return this;
  }

  public ContactDataBuilder notes(String notes) {
    contactData.setNotes(notes);
    return this;
  }

  public ContactDataBuilder homePhone(String homePhone) {
    contactData.setHomePhone(homePhone);
    return this;
  }

  public ContactDataBuilder mobilePhone(String mobilePhone) {
    contactData.setMobilePhone(mobilePhone);
    return this;
  }

  public ContactDataBuilder workPhone(String workPhone) {
    contactData.setWorkPhone(workPhone);
    return this;
  }

  public ContactDataBuilder fax(String fax) {
    contactData.setFax(fax);
    return this;
  }


  public ContactDataBuilder secondaryAdress(String secondaryAdress) {
    contactData.setSecondaryAdress(secondaryAdress);
    return this;
  }

  public ContactDataBuilder secondaryPhone(String secondaryPhone) {
    contactData.setSecondaryPhone(secondaryPhone);
    return this;
  }

  public ContactDataBuilder photoDirectory(String photoDirectory) {
    contactData.setPhoto(photoDirectory);
    return this;
  }

  public ContactDataBuilder birthday(LocalDate birthday) {
    contactData.setBirthday(birthday);
    return this;
  }

  public ContactDataBuilder anniversary(LocalDate anniversary) {
    contactData.setAnniversary(anniversary);
    return this;
  }

  public ContactDataBuilder group(Set<GroupData> group) {
    contactData.setGroup(group);
    return this;
  }

  public ContactDataBuilder homepage(String homepage) {
    contactData.setHomepage(homepage);
    return this;
  }

  public ContactDataBuilder nameId(Integer setNameId) {
    contactData.setNameId(setNameId);
    return this;
  }

  public ContactData build() {
    return contactData;
  }

  public ContactDataBuilder withAllAddress(String allAddress) {
    contactData.setAllAddress(allAddress);
    return this;
  }
}