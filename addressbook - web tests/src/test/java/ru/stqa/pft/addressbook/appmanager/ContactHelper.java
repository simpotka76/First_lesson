package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.ContactDataBuilder;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  GroupHelper groupHelper = new GroupHelper(wd);
  NavigationHelper navigationHelper = new NavigationHelper(wd);

  public ContactHelper(WebDriver wd) {

    super(wd);
  }

  public void fillSecondaryAddress(ContactData secondaryAddressData) {
    type(secondaryAddressData.getSecondaryAdress(), By.name("address2"));
  }

  public void fillCompanyForms(ContactData contactData) {
    type(contactData.getTitle(), By.name("title"));
    type(contactData.getCompany(), By.name("company"));
    type(contactData.getCompanyAddress(), By.name("address"));
  }

  public void fillAnyversary(ContactData datesData) {
    click(By.name("aday"));
    select(By.name("aday"), datesData.getDay());
    click(By.xpath("//div[@id='content']/form/select[3]/option[19]"));
    click(By.name("amonth"));
    select(By.name("amonth"), datesData.getMonth());
    click(By.xpath("//div[@id='content']/form/select[4]/option[12]"));
    type(datesData.getYear(), By.name("ayear"));
  }

  public void fillBirthday(ContactData birthdayData) {
    click(By.name("bday"));
    select(By.name("bday"), birthdayData.getDay());
    click(By.xpath("//option[@value='15']"));
    click(By.name("bmonth"));
    select(By.name("bmonth"), birthdayData.getMonth());
    click(By.xpath("//option[@value='August']"));
    type(birthdayData.getYear(), By.name("byear"));
  }

  public void fillEmailsForms(ContactData emailsData) {
    type(emailsData.getEmail1(), By.name("email"));
    type(emailsData.getEmail2(), By.name("email2"));
    type(emailsData.getEmail3(), By.name("email3"));
  }

  public void fillNamesForms(ContactData namesData) {
    type(namesData.getFirstname(), By.name("firstname"));
    type(namesData.getMiddleName(), By.name("middlename"));
    type(namesData.getLastname(), By.name("lastname"));
    type(namesData.getNickname(), By.name("nickname"));
  }

  public void fillNotes(ContactData notesData) {
    type(notesData.getNotes(), By.name("notes"));
  }

  public void fillSecondaryPhone(ContactData secondaryPhoneData) {
    type(secondaryPhoneData.getSecondaryPhone(), By.name("phone2"));
  }

  public void fillPhonesForms(ContactData phonesData) {
    type(phonesData.getHomePhone(), By.name("home"));
    type(phonesData.getMobilePhone(), By.name("mobile"));
    type(phonesData.getWorkPhone(), By.name("work"));
    type(phonesData.getFax(), By.name("fax"));
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.tagName("tr"));
    for (int i = 1; i < elements.size(); i++) {
      List<WebElement> colVals = elements.get(i).findElements(By.tagName("td"));
      contacts.add(new ContactDataBuilder()
              .firstname(colVals.get(2).getText())
              .lastname(colVals.get(1).getText())
              .build());
    }
    return contacts;
  }

  public void getCreationContact() {
    navigationHelper.addNewContact();
    fillNamesForms(new ContactDataBuilder().firstname("Alex")
            .middleName("Bolduin")
            .lastname("Bolduin")
            .nickname("Boldi")
            .build());
    navigationHelper.addPhoto(new ContactDataBuilder()
            .photoDirectory("resources/Bolduin.jpg")
            .build());
    fillCompanyForms(new ContactDataBuilder()
            .title("Boldo-Voldo")
            .company("Fox")
            .companyAddress("Usa, bryton beach 48")
            .build());
    fillPhonesForms(new ContactDataBuilder()
            .homePhone("+78954523")
            .fax("None")
            .mobilePhone("+735645645")
            .workPhone("+2344234432")
            .build());
    fillEmailsForms(new ContactDataBuilder()
            .email1("boldi@jojo.com")
            .email2("holo@gmail.com")
            .email3("gop@jojo.com")
            .build());
    navigationHelper.fillHomepage(new ContactDataBuilder()
            .homepage("yandex.ru")
            .build());
    fillBirthday(new ContactDataBuilder()
            .day("15")
            .month("August")
            .year("1989")
            .build());
    fillAnyversary(new ContactDataBuilder()
            .day("17")
            .month("August")
            .year("1989")
            .build());
    if (groupHelper.checkGroups()) {
      groupHelper.chooseGroup(new ContactDataBuilder()
              .group("Test 1")
              .creation(true)
              .build());
    }
    fillSecondaryAddress(new ContactDataBuilder()
            .secondaryAdress("Usa, Briton beach")
            .build());
    fillSecondaryPhone(new ContactDataBuilder()
            .secondaryPhone("48")
            .build());
    fillNotes(new ContactDataBuilder()
            .notes("Best friend")
            .build());
    navigationHelper.submitNewContact();
    navigationHelper.goToHomepage();
  }
}





