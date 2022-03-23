package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.appmanager.TestBase;
import ru.stqa.pft.adressbook.model.*;

public class NewContactCreationTest extends TestBase {

  @Test

  public void testNewContactCreation() {
    app.getNavigationHelper().addNewContact();
    app.getContactHelper().fillNamesForms(new ContactDataBuilder()
            .firstname("Alex")
            .middleName("Bolduin")
            .lastname("Bolduin")
            .nickname("Boldi")
            .builder());
    app.getNavigationHelper().addPhoto(new ContactDataBuilder()
          .photoDirectory("C:\\Users\\Kakaperduk\\Downloads\\Bolduin.jpg")
          .builder());
    app.getContactHelper().fillCompanyForms(new ContactDataBuilder()
            .title("Boldo-Voldo")
            .company("Fox")
            .companyAddress("Usa, bryton beach 48")
            .builder());
    app.getContactHelper().fillPhonesForms(new ContactDataBuilder()
            .homePhone("+78954523")
            .fax("None")
            .mobilePhone("+735645645")
            .workPhone("+2344234432")
            .builder());
    app.getContactHelper().fillEmailsForms(new ContactDataBuilder()
            .email1("boldi@jojo.com")
            .email2("holo@gmail.com")
            .email3("gop@jojo.com")
            .builder());
    app.getNavigationHelper().fillHomepage(new ContactDataBuilder()
            .homepage("yandex.ru")
            .builder());
    app.getContactHelper().fillBirthday(new ContactDataBuilder()
            .day("15")
            .month("August")
            .year("1989")
            .builder());
    app.getContactHelper().fillAnyversary(new ContactDataBuilder()
            .day("17")
            .month("August")
            .year("1989")
            .builder());
    app.getGroupHelper().chooseGroup(new ContactDataBuilder()
            .group("Test1")
            .builder());
    app.getContactHelper().fillSecondaryAddress(new ContactDataBuilder()
            .secondaryAdress("Usa, Briton beach")
            .builder());
    app.getContactHelper().fillSecondaryPhone(new ContactDataBuilder()
            .secondaryPhone("48")
            .builder());
    app.getContactHelper().fillNotes(new ContactDataBuilder()
            .notes("Best friend")
            .builder());
    app.getNavigationHelper().submitNewContact();
    app.getNavigationHelper().goToHomepage();

  }

}
