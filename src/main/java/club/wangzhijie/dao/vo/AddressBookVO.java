package club.wangzhijie.dao.vo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author 8bit
 */
public class AddressBookVO {
    private final IntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty telephone;
    private final SimpleStringProperty mail;

    public AddressBookVO() {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.telephone = new SimpleStringProperty();
        this.mail = new SimpleStringProperty();
    }

    public AddressBookVO(String name, String telephone, String mail) {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty(name);
        this.telephone = new SimpleStringProperty(telephone);
        this.mail = new SimpleStringProperty(mail);
    }

    public AddressBookVO(int id, String name, String telephone, String mail) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.telephone = new SimpleStringProperty(telephone);
        this.mail = new SimpleStringProperty(mail);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getTelephone() {
        return telephone.get();
    }

    public SimpleStringProperty telephoneProperty() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone.set(telephone);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getMail() {
        return mail.get();
    }

    public SimpleStringProperty mailProperty() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail.set(mail);
    }
}