package controllers;

import models.Category;
import services.Category.CategoryService;
import services.Category.CategoryServiceImpl;

import java.util.List;
import java.util.Scanner;

public class CategoryController {
    public static void main(String[] args) {
        CategoryService categoryService = new CategoryServiceImpl();
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            showOption();
            System.out.println("Choose option : ");
            input = scanner.nextInt();
            switch (input) {
                case 1 -> {
                    System.out.println("=======List Categories========================");
                    List<Category> categoryList = categoryService.GetAllData();
                    for (Category ss : categoryList) {
                        System.out.println("-------------------------");
                        System.out.println("Category ID : " + ss.getId());
                        System.out.println("Category Name : " + ss.getName());
                        System.out.println("Category Name Khmer : " + ss.getNameKh());
                        System.out.println("-------------------------");
                    }
                }
                case 2 -> {
                    System.out.println("================Insert Category=================");
                    Category createCategory = new Category();
                    System.out.println(("Enter category name:"));
                    createCategory.setName(scanner.next());
                    System.out.println(("Enter category name_kh:"));
                    createCategory.setNameKh(scanner.next());
                    categoryService.Insert(createCategory);
                }
                case 3 -> {
                    System.out.print("Enter category id : ");
                    Integer findId = scanner.nextInt();
                    Category findcategory = categoryService.getById(findId);
                    if (findcategory.getName() != null) {
                        System.out.println("-----------Find By Id--------------");
                        System.out.println("Category ID : " + findcategory.getId());
                        System.out.println("Category Name : " + findcategory.getName());
                        System.out.println("Category Name Khmer : " + findcategory.getNameKh());
                        System.out.println("-------------------------");
                    }
                }
                case 4 -> {
                    System.out.print("Enter Category id : ");
                    Integer updated = scanner.nextInt();
                    Category updatecategory = categoryService.getById(updated);
                    System.out.println(("Enter category name:"));
                    updatecategory.setName(scanner.next());
                    System.out.println(("Enter category name_kh:"));
                    updatecategory.setNameKh(scanner.next());
                    categoryService.update(updatecategory, updated);
                }
                case 5 -> {
                    System.out.print("Enter Category id : ");
                    Integer dId = scanner.nextInt();
                    categoryService.delete(dId);
                }
            }
        } while (input != 0);
    }

    public static void showOption() {
        System.out.println("===================================================================================================");
        System.out.println("1. List Category | 2. Insert Category | 3.Get By Id | 4.Update Category | 5. Delete Category | 0.Exit");
        System.out.println("===================================================================================================");
    }

}
