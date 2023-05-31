package controllers;

import models.Users;
import services.Users.UserServiceImpl;
import services.Users.UsersService;

import java.util.List;
import java.util.Scanner;

public class UserController
{
    public static void main(String[] args)
    {
        UsersService usersService=new UserServiceImpl();
        Scanner scanner = new Scanner(System.in);
        int input=0;
        do {
            showOption();
            System.out.println("Choose option : ");
            input = scanner.nextInt();
            switch (input) {
                case 1 -> {
                    System.out.println("=======List Categories========================");
                    List<Users> usersList = usersService.GetAllData();
                    for (Users ss : usersList) {
                        System.out.println("-------------------------");
                        System.out.println("User ID : " + ss.getId());
                        System.out.println("FirstName: " + ss.getFirstname());
                        System.out.println("LastName: " + ss.getLastName());
                        System.out.println("Email: " + ss.getEmail());
                        System.out.println("Address: " + ss.getAddress());
                        System.out.println("-------------------------");
                    }

                }
                case 2 -> {
                    System.out.println("================Insert Users=================");
                    Users createUser = new Users();
                    System.out.println(("FirstName:"));
                    createUser.setFirstname(scanner.next());
                    System.out.println(("LastName:"));
                    createUser.setLastName(scanner.next());
                    System.out.println(("Email:"));
                    createUser.setEmail(scanner.next());
                    System.out.println(("Address:"));
                    createUser.setAddress(scanner.next());
                    usersService.Insert(createUser);

                }
                case 3 -> {
                    System.out.print("Enter User id : ");
                    Integer findId = scanner.nextInt();
                    Users findUser = usersService.getById(findId);
                    if (findUser.getEmail() != null) {
                        System.out.println("-----------Find By Id--------------");
                        System.out.println("User ID : " + findUser.getId());
                        System.out.println("FirstName : " + findUser.getFirstname());
                        System.out.println("LastName: " + findUser.getLastName());
                        System.out.println("Email: " + findUser.getEmail());
                        System.out.println("Address: " + findUser.getAddress());
                        System.out.println("-------------------------");

                    }
                }
                case 4 -> {
                    System.out.print("Enter User id : ");
                    Integer updatedId = scanner.nextInt();
                    Users updateUsers = usersService.getById(updatedId);
                    System.out.println(("FirstName:"));
                    updateUsers.setFirstname(scanner.next());
                    System.out.println(("LastName:"));
                    updateUsers.setLastName(scanner.next());
                    System.out.println(("Email:"));
                    updateUsers.setEmail(scanner.next());
                    System.out.println(("Address:"));
                    updateUsers.setAddress(scanner.next());
                    usersService.update(updateUsers,updatedId);
                }
                case 5 -> {
                    System.out.print("Enter Category id : ");
                    Integer dId = scanner.nextInt();
                    usersService.delete(dId);

                }

            }
        } while (input != 0);
    }
    public static void showOption() {
        System.out.println("===================================================================================================");
        System.out.println("1. List Users | 2. Insert Users | 3.Get By Id | 4.Update Users | 5. Delete Users | 0.Exit");
        System.out.println("===================================================================================================");
    }
}
