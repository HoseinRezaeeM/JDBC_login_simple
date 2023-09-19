package service;

import models.Shareholder;
import repository.ShareholderRepository;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ShareholderService {
    private final ShareholderRepository shareholderRepository;
    private final Scanner scanner = new Scanner(System.in);

    public ShareholderService(ShareholderRepository shareholderRepository) {
        this.shareholderRepository = shareholderRepository;
    }

    public void register(Shareholder shareholder) throws SQLException {
        int result = shareholderRepository.save(shareholder);
        if (result != 0)
            System.out.println(shareholder.getName() + " successfully added to database");
        else
            System.out.println("--Error404--");

    }

    public void update(int idShareholder) throws SQLException {
        System.out.println("Enter new name :");
        String name = scanner.next();
        System.out.println("Enter new phoneNumber :");
        String phoneNumber = scanner.next();
        System.out.println("Enter new nationalCode : ");
        String nationalCode = scanner.next();
        int result = shareholderRepository.updateInfoShareholder(name, phoneNumber, nationalCode, idShareholder);
        if (result != 0)
            System.out.println("successfully edited to database");
        else {
            System.out.println("Eror404");
        }
    }

    public void delete(int idShareholder) throws SQLException {
        int result = shareholderRepository.delete(idShareholder);
        if (result != 0) {
            System.out.println("successfully deleted from database");
        } else {
            System.out.println("---Eror404--");
        }

    }
}
