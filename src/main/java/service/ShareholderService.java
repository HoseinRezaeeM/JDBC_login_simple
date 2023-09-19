package service;

import models.Shareholder;
import repository.ShareholderRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class ShareholderService {
    private final ShareholderRepository shareholderRepository;
    private final Scanner scanner=new Scanner(System.in);

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
    public void update(int idShareholder) throws SQLException{

    }
}
