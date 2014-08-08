package com.baldurtech;

public class ContactRepository {
    private DatabaseManager db;
    private Contact contact;
    public ContactRepository(DatabaseManager db) {
        this.db = db;
    }
    public void deleteById(Long id) {
        db.executeUpdate("DELETE FROM contact WHERE id=" + id);
    }
    public void update(Contact contact) {
        String sql = "UPDATE contact SET name=?,mobile=?,vpmn=?,email=?,home_address=?,office_address=?,memo=?,job=?,job_level=? WHERE id=?";
        
        db.executeUpdate(sql,contact.getName(),contact.getMobile(),contact.getVpmn(),contact.getEmail(),contact.getHomeAddress(),contact.getOfficeAddress(),contact.getMemo(),contact.getJob(),contact.getJobLevel(),contact.getId());
    }
}