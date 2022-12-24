package club.wangzhijie.view;

import club.wangzhijie.dao.AddressBookDAOImpl;
import club.wangzhijie.dao.impl.AddressBookMapper;
import club.wangzhijie.dao.po.AddressBookPO;
import club.wangzhijie.dao.vo.AddressBookVO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.List;
import java.util.Objects;

/**
 * @author 母丹婷
 */
public class MainController {
    @FXML
    private TextField nameTextfield;
    @FXML
    private TextField telephoneTextfield;
    @FXML
    private TextField mailTextfield;
    @FXML
    private TextField searchText;
    @FXML
    private TableColumn<AddressBookVO, Number> idTableColumn;
    @FXML
    private TableColumn<AddressBookVO, String> nameTableColumn;
    @FXML
    private TableColumn<AddressBookVO, String> telephoneTableColumn;
    @FXML
    private TableColumn<AddressBookVO, String> mailTableColumn;
    @FXML
    public TableView<AddressBookVO> addressGrid;

    @FXML
    private void initialize() {
        idTableColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        nameTableColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        telephoneTableColumn.setCellValueFactory(cellData -> cellData.getValue().telephoneProperty());
        mailTableColumn.setCellValueFactory(cellData -> cellData.getValue().mailProperty());
        fillingTableView(new AddressBookDAOImpl().findAll());
        searchText.textProperty().addListener((observableValue, s, t1) -> {
//            Modify by 8bit at 2022/12/24 13:29
//            if ("*".equals(t1)) {
//                fillingTableView(new AddressBookDAOImpl().findAll());
//                return;
//            }
            fillingTableView(new AddressBookDAOImpl().findName(t1));
        });
    }

    private void fillingTableView(List<AddressBookPO> addressBookPOList) {
        this.addressGrid.getItems().clear();
        List<AddressBookVO> addressBookVOList = AddressBookMapper.MAPPER.listpo2vo(addressBookPOList);
        for (int i = 1;i <= addressBookVOList.size();i++) {
            addressBookVOList.get(i - 1).setId(i);
        }
        this.addressGrid.getItems().setAll(addressBookVOList);
    }

    @FXML
    public void onAppendAddressClick(ActionEvent actionEvent) {
        if (Objects.equals(nameTextfield.textProperty().getValue(), "")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("姓名不能为空,请输入后重试");
            alert.showAndWait();
            return;
        }
        if (Objects.equals(telephoneTextfield.textProperty().getValue(), "") || telephoneTextfield.textProperty().getValue().length() > 11) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("电话号码为空或者过长,请重新输入");
            alert.showAndWait();
            return;
        }
        if (Objects.equals(mailTextfield.textProperty().getValue(), "")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("电子邮件不能为空,请输入后重试");
            alert.showAndWait();
            return;
        }
        AddressBookVO addressBookVO = new AddressBookVO(nameTextfield.textProperty().getValue(),
                telephoneTextfield.textProperty().getValue(),
                mailTextfield.textProperty().getValue());
        new AddressBookDAOImpl().doCreate(AddressBookMapper.MAPPER.vo2po(addressBookVO));
        fillingTableView(new AddressBookDAOImpl().findAll());
    }

    @FXML
    public void onDeleteAddressClick(ActionEvent actionEvent) {
        ObservableList<AddressBookVO> observableList = this.addressGrid.getSelectionModel().getSelectedItems();
        if (observableList == null) {
            return;
        }
        for (AddressBookVO addressBookVO : observableList) {
            new AddressBookDAOImpl().deleteId(addressBookVO.getName());
        }
        fillingTableView(new AddressBookDAOImpl().findAll());
    }

    @FXML
    public void onModifyAddressClick(ActionEvent actionEvent) {
        String name = this.addressGrid.getSelectionModel().getSelectedItems().get(0).getName();
        AddressBookVO addressBookVO = new AddressBookVO(this.nameTextfield.textProperty().getValue(), this.telephoneTextfield.textProperty().getValue(), this.mailTextfield.textProperty().getValue());
        new AddressBookDAOImpl().modifyAddress(name, AddressBookMapper.MAPPER.vo2po(addressBookVO));
        fillingTableView(new AddressBookDAOImpl().findAll());
    }

    public void onAddressGridMouseClicked(MouseEvent mouseEvent) {
        AddressBookVO addressBookVO = this.addressGrid.getSelectionModel().getSelectedItems().get(0);
        this.nameTextfield.textProperty().setValue(addressBookVO.getName());
        this.telephoneTextfield.textProperty().setValue(addressBookVO.getTelephone());
        this.mailTextfield.textProperty().setValue(addressBookVO.getMail());
    }
}