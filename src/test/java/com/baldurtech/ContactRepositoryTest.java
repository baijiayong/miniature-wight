package com.baldurtech;

import com.baldurtech.unit.MiniatureSpiceTestCase;

public class ContactRepositoryTest extends MiniatureSpiceTestCase {
    
    public void test_根据指定id删除Contact() {
        DatabaseManagerMock db = new DatabaseManagerMock();
        ContactRepository contactRepository = new ContactRepository(db);
        
        contactRepository.deleteById(1L);
        
        assertEquals("DELETE FROM contact WHERE id=1",db.executeUpdateParam);
    }
    public void test_更新指定的Contact() {
        DatabaseManagerMock db = new DatabaseManagerMock();
        ContactRepository contactRepository = new ContactRepository(db);
        
        Contact contact = new Contact();
        contact.setId(1L);
        contact.setName("Tom");
        contact.setMobile("1390000000");
        contact.setEmail("xiaobai@gmail.com");
        
        contactRepository.update(contact);
        
        assertEquals("UPDATE contact SET name=?,mobile=?,vpmn=?,email=?,home_address=?,office_address=?,memo=?,job=?,job_level=? WHERE id=?",db.executeUpdateParam);
        assertArrayEquals(new Object[]{"Tom","1390000000",null,"xiaobai@gmail.com",null,null,null,null,null,1L},db.executeUpdateParam2);
    }
}

