package structural_patterns.db_executor_dao;

import structural_patterns.db_executor_dao.entity.User;
import structural_patterns.db_executor_dao.service.UserService;

public class Main {
    public static void main(String[] args) {
        UserService dbService = new UserService();
        DBConnectionStore.getInstance().printConnectInfo();
        try {
            long userId = dbService.addUser("tully");
            System.out.println("Added user id: " + userId);

            User dataSet = dbService.getUser(userId);
            System.out.println("User data set: " + dataSet);

            dbService.cleanUp();
        } catch (DBException e)

        {
            e.printStackTrace();
        }
    }
}
