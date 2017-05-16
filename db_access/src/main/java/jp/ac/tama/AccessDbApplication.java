package jp.ac.tama;

import jp.ac.tama.model.PhoneNumber;
import jp.ac.tama.model.User;
import jp.ac.tama.service.PhoneNumberDAO;
import jp.ac.tama.service.UserDAO;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessDbApplication implements CommandLineRunner
{

	public static void main(String[] args) {
		SpringApplication.run(AccessDbApplication.class, args);
	}

	@Autowired
	UserDAO userDao;
	PhoneNumberDAO phoneNumberDAO;

	@Override
	public void run(String... args) throws Exception {
		val users = userDao.selectUserList();
		System.out.println(users);

		//	データ追加
		val newUser = new User("12345678","山田太郎");
		userDao.insertUser(newUser);

		val newUsers = userDao.selectUserList();
		System.out.println(newUsers);
		newUser.setName("山田花子");
		userDao.updateUser(newUser);

		val updateUsers = userDao.selectUserList();
		System.out.println(updateUsers);
		//	userDao.deleteUser(newUser.getId());

		val deleteUsers = userDao.selectUserList();
		System.out.println(deleteUsers);

		//	----------------------

		val phoneNumbers = phoneNumberDAO.selectPhoneNumberList();
		System.out.println(phoneNumbers);

		val newPhoneNumber = new PhoneNumber("090-1111-1111","山田太郎");
		userDao.insertUser(newUser);

		val newPhoneNumbers = phoneNumberDAO.selectPhoneNumberList();
		System.out.println(newPhoneNumbers);
		newPhoneNumber.setName("山田花子");
		phoneNumberDAO.updatePhoneNumber(newPhoneNumber);

		val updatePhoneNumbers = phoneNumberDAO.selectPhoneNumberList();
		System.out.println(updatePhoneNumbers);
		//	phoneNumberDAO.deleteUser(newUser.getId());

		val deletePhoneNumbers = phoneNumberDAO.selectPhoneNumberList();
		System.out.println(deletePhoneNumbers);
	}
}
