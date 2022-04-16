package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new GroupData().withName("Test 1").withHeader("Header 1").withFooter("Footer 1")});
        list.add(new Object[]{new GroupData().withName("Test 2").withHeader("Header 2").withFooter("Footer 3")});
        list.add(new Object[]{new GroupData().withName("Test 3").withHeader("Header 2").withFooter("Footer 3")});
        return list.iterator();
    }

    @Test(dataProvider = "validGroups" )
    public void testGroupCreation(GroupData group) {
        app.goTo().group();
        Groups before = app.group().all();
        app.group().create(group);
        assertThat(app.group().count(),equalTo(before.size()+1));
        Groups after = app.group().all();
        assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt(GroupData::getId).max().getAsInt()))));
    }
}