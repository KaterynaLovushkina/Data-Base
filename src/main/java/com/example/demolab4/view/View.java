package com.example.demolab4.view;

import com.example.demolab4.controller.*;
import com.example.demolab4.domain.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class View {
    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private final Scanner input = new Scanner(System.in);

    private final AppCategoryController appCategoryController;
    private final CategoryController categoryController;
    private final AppController appController;
    private final CreaterController createrController;
    private final UserController userController;
    private final DownloadController downloadController;
    private final FeedbackController feedbackController;

    public View(AppCategoryController appCategoryController,
                CategoryController categoryController, AppController appController,
                CreaterController createrController, UserController userController,
                DownloadController downloadController, FeedbackController feedbackController) {
        this.appCategoryController = appCategoryController;
        this.categoryController = categoryController;
        this.appController = appController;
        this.createrController = createrController;
        this.userController = userController;
        this.downloadController = downloadController;
        this.feedbackController = feedbackController;

        this.menu = new LinkedHashMap<>();
        this.methodsMenu = new HashMap<>();

        menu.put("A", "  A - Select all table");

        menu.put("1", "1 - Table: AppCategory");
        menu.put("11", "11 - create AppCategory");
        menu.put("12", "12 - update AppCategory");
        menu.put("13", "13 - delete AppCategory");
        menu.put("14", "14 - find AppCategory by Id");
        menu.put("15", "15 - find all AppCategory");

        menu.put("2", "2 - Table: Category");
        menu.put("21", "21 - create Category");
        menu.put("22", "22 - update Category");
        menu.put("23", "23 - delete Category");
        menu.put("24", "24 - find Category by Id");
        menu.put("25", "25 - find all Category");

        menu.put("3", "3 - Table: App");
        menu.put("31", "31 - create App");
        menu.put("32", "32 - update App");
        menu.put("33", "33 - delete App");
        menu.put("34", "34 - find App by Id");
        menu.put("35", "35 - find all Apps");
        menu.put("36", "36 - find all free Apps");
        menu.put("37", "37 - find App by Category");

        menu.put("4", "4 - Table: Creater");
        menu.put("41", "41 - create Creater");
        menu.put("42", "42 - update Creater");
        menu.put("43", "43 - delete Creater");
        menu.put("44", "44 - find Creater by Id");
        menu.put("45", "45 - find all Creaters");
        menu.put("46", "46 - find  Creaters by Work Branch");
        menu.put("47", "47 - find  Creaters of App");

        menu.put("5", "5 - Table: User");
        menu.put("51", "51 - create User");
        menu.put("52", "52 - update User");
        menu.put("53", "53 - delete User");
        menu.put("54", "54 - find User by Id");
        menu.put("55", "55 - find all User");
        menu.put("56", "56 - find all User of App");

        menu.put("6", "6 - Table: Download");
        menu.put("61", "61 - create Download");
        menu.put("62", "62 - update Download");
        menu.put("63", "63 - delete Download");
        menu.put("64", "64 - find Download by Id");
        menu.put("65", "65 - find all Download");

        menu.put("7", "7 - Table: Feedback");
        menu.put("71", "71 - create Feedback");
        menu.put("72", "72 - update Feedback");
        menu.put("73", "73 - delete Feedback");
        menu.put("74", "74 - find Feedback by Id");
        menu.put("75", "75 - find all Feedback");
        menu.put("76", "76 - find all Feedback by User");

        menu.put("Q", "  Q - exit");

        methodsMenu.put("A", this::selectAllTable);
        methodsMenu.put("11", this::createAppCategory);
        methodsMenu.put("12", this::updateAppCategory);
        methodsMenu.put("13", this::deleteAppCategory);
        methodsMenu.put("14", this::findAppCategoryById);
        methodsMenu.put("15", this::findAllAppCategories);

        methodsMenu.put("21", this::createCategory);
        methodsMenu.put("22", this::updateCategory);
        methodsMenu.put("23", this::deleteCategory);
        methodsMenu.put("24", this::findCategoryById);
        methodsMenu.put("25", this::findAllCategories);

        methodsMenu.put("31", this::createApp);
        methodsMenu.put("32", this::updateApp);
        methodsMenu.put("33", this::deleteApp);
        methodsMenu.put("34", this::findAppById);
        methodsMenu.put("35", this::findAllApps);
        methodsMenu.put("36", this::findAllFreeApps);
        methodsMenu.put("37", this::findAppByCategoryName);

        methodsMenu.put("41", this::createCreater);
        methodsMenu.put("42", this::updateCreater);
        methodsMenu.put("43", this::deleteCreater);
        methodsMenu.put("44", this::findCreaterById);
        methodsMenu.put("45", this::findAllCreaters);
        methodsMenu.put("46", this::findByWorkBranch);
        methodsMenu.put("47", this::findAppsAndCreaters);


        methodsMenu.put("51", this::createUser);
        methodsMenu.put("52", this::updateUser);
        methodsMenu.put("53", this::deleteUser);
        methodsMenu.put("54", this::findUserById);
        methodsMenu.put("55", this::findAllUsers);
        methodsMenu.put("56", this::findAllUsersOfApp);

        methodsMenu.put("61", this::createDownload);
        methodsMenu.put("62", this::updateDownload);
        methodsMenu.put("63", this::deleteDownload);
        methodsMenu.put("64", this::findDownloadById);
        methodsMenu.put("65", this::findAllDownloads);

        methodsMenu.put("71", this::createFeedback);
        methodsMenu.put("72", this::updateFeedback);
        methodsMenu.put("73", this::deleteFeedback);
        methodsMenu.put("74", this::findFeedbackById);
        methodsMenu.put("75", this::findAllFeedbacks);
        methodsMenu.put("76", this::findAllFeedbacksByUser);

    }


    private void selectAllTable() {
        findAllAppCategories();
        findAllCategories();
        findAllApps();
        findAllCreaters();
        findAllUsers();
        findAllDownloads();
        findAllFeedbacks();
    }


    // -------------------------------------AppCategory------------------------
    private void createAppCategory(){
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'description': ");
        String description = input.nextLine();
        AppCategory appCategory = new AppCategory(null, name, description);


        try {
            appCategoryController.create(appCategory);
            System.out.println("Successfully created");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t create");
        }
    }
    private void updateAppCategory() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'name': ");
        String name = input.nextLine();
        System.out.println("Input new 'description': ");
        String description = input.nextLine();
        AppCategory appCategory = new AppCategory(null, name, description);


        try {
            appCategoryController.update(id,appCategory);
            System.out.println("Successfully updated");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t update");
        }
    }
    private void deleteAppCategory() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        try {
            appCategoryController.delete(id);
            System.out.println("Successfully deleted");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t delete");
        }
    }
    private void findAppCategoryById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        try {
            Optional<AppCategory> appCategory= appCategoryController.findById(id);
            System.out.println(appCategory);
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t find");
        }
    }
    private void findAllAppCategories() {
        System.out.println("Table: AppCategory");
        List<AppCategory> all = appCategoryController.findAll();
        for (AppCategory appCategory : all) {
            System.out.println(appCategory);
        }
    }



    // -------------------------------------Category------------------------
    private void createCategory(){
        System.out.println("Input 'audience_type': ");
        String audience_type = input.nextLine();
        System.out.println("Input 'app_category_id': ");
        Integer app_category_id = Integer.valueOf(input.nextLine());
        Category category = new Category(null, audience_type, app_category_id);


        try {
            categoryController.create(category);
            System.out.println("Successfully created");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t create");
        }
    }
    private void updateCategory() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'audience_type': ");
        String audience_type = input.nextLine();
        System.out.println("Input 'app_category_id': ");
        Integer app_category_id = Integer.valueOf(input.nextLine());
        Category category = new Category(null, audience_type, app_category_id);


        try {
            categoryController.update(id,category);
            System.out.println("Successfully updated");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t update");
        }
    }
    private void deleteCategory() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        try {
            categoryController.delete(id);
            System.out.println("Successfully deleted");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t delete");
        }
    }
    private void findCategoryById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        try {
            Optional<Category> category= categoryController.findById(id);
            System.out.println(category);
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t find");
        }
    }
    private void findAllCategories() {
        System.out.println("Table: Category");
        List<Category> all = categoryController.findAll();
        for (Category category : all) {
            System.out.println(category);
        }
    }

    // -------------------------------------App------------------------
    private void createApp(){
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'description': ");
        String description = input.nextLine();
        System.out.println("Input 'weight_in_mb': ");
        Integer weight_in_mb = Integer.valueOf(input.nextLine());
        System.out.println("Input 'create_date': ");
        String create_date = input.nextLine();
        System.out.println("Input 'is_free': ");
        Boolean is_free = Boolean.valueOf(input.nextLine());
        System.out.println("Input 'price_in_dollars': ");
        Float price_in_dollars = Float.valueOf(input.nextLine());
        System.out.println("Input 'has_advert': ");
        Boolean has_advert = Boolean.valueOf(input.nextLine());
        System.out.println("Input 'category_id': ");
        Integer category_id = Integer.valueOf(input.nextLine());

        App app = new App(null, name, description,
                weight_in_mb,create_date,is_free,
                price_in_dollars,has_advert,category_id);

        try {
            appController.create(app);
            System.out.println("Successfully created");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t create");
        }
    }
    private void updateApp() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'name': ");
        String name = input.nextLine();
        System.out.println("Input new 'description': ");
        String description = input.nextLine();
        System.out.println("Input new 'weight_in_mb': ");
        Integer weight_in_mb = Integer.valueOf(input.nextLine());
        System.out.println("Input new 'create_date': ");
        String create_date = input.nextLine();
        System.out.println("Input new 'is_free': ");
        Boolean is_free = Boolean.valueOf(input.nextLine());
        System.out.println("Input new 'price_in_dollars': ");
        Float price_in_dollars = Float.valueOf(input.nextLine());
        System.out.println("Input new 'has_advert': ");
        Boolean has_advert = Boolean.valueOf(input.nextLine());
        System.out.println("Input new 'category_id': ");
        Integer category_id = Integer.valueOf(input.nextLine());

        App app = new App(null, name, description,
                weight_in_mb,create_date,is_free,
                price_in_dollars,has_advert,category_id);

        try {
            appController.update(id,app);
            System.out.println("Successfully updated");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t update");
        }
    }
    private void deleteApp() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        try {
            appController.delete(id);
            System.out.println("Successfully deleted");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t delete");
        }
    }
    private void findAppById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        try {
            Optional<App> app= appController.findById(id);
            System.out.println(app);
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t find");
        }
    }
    private void findAllApps() {
        System.out.println("Table: App");
        List<App> all = appController.findAll();
        for (App app : all) {
            System.out.println(app);
        }
    }
    private void findAllFreeApps() {
        System.out.println("Table: App");
        List<App> all = appController.getAllFreeApps();
        for (App app : all) {
            System.out.println(app);
        }
    }
    private void findAppByCategoryName() {
        System.out.println("Input 'category_name': ");
        String name = input.nextLine();

        try {
            List<App> apps= appController.getAppsByCategory(name);
            for(App app : apps){
                System.out.println(app);
            }
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t find");
        }
    }

    // -------------------------------------Creater------------------------
    private void createCreater(){
        System.out.println("Input 'full_name': ");
        String full_name = input.nextLine();
        System.out.println("Input 'work_branch': ");
        String work_branch = input.nextLine();
        System.out.println("Input 'email': ");
        String email = input.nextLine();
        System.out.println("Input 'created_app_amount': ");
        Integer created_app_amount = Integer.valueOf(input.nextLine());
        Creater creater = new Creater(null, full_name, work_branch,email,created_app_amount);


        try {
            createrController.create(creater);
            System.out.println("Successfully created");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t create");
        }
    }
    private void updateCreater() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'full_name': ");
        String full_name = input.nextLine();
        System.out.println("Input new 'work_branch': ");
        String work_branch = input.nextLine();
        System.out.println("Input new 'email': ");
        String email = input.nextLine();
        System.out.println("Input new 'created_app_amount': ");
        Integer created_app_amount = Integer.valueOf(input.nextLine());
        Creater creater = new Creater(null, full_name, work_branch,email,created_app_amount);

        try {
            createrController.update(id,creater);
            System.out.println("Successfully updated");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t update");
        }
    }
    private void deleteCreater() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        try {
            createrController.delete(id);
            System.out.println("Successfully deleted");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t delete");
        }
    }
    private void findCreaterById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        try {
            Optional<Creater> creater= createrController.findById(id);
            System.out.println(creater);
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t find");
        }
    }
    private void findAllCreaters() {
        System.out.println("Table: Creaters");
        List<Creater> all = createrController.findAll();
        for (Creater creater : all) {
            System.out.println(creater);
        }
    }
    private void findByWorkBranch() {
        System.out.println("Input 'work_branch': ");
        String workBranch = input.nextLine();

        try {
            List<Creater> creaters= createrController.getAllCreatersByWorkBranch(workBranch);
            for(Creater creater : creaters){
                System.out.println(creater);
            }
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t find");
        }
    }
    private void findAppsAndCreaters() {
        System.out.println("Input 'app_name': ");
        String appName = input.nextLine();
        try {
            List<Creater> creaters= createrController.getCreatersByApp(appName);
            for(Creater creater : creaters){
                System.out.println(creater);
            }
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t find");
        }
    }

    // -------------------------------------User------------------------
    private void createUser(){
        System.out.println("Input 'password_hash': ");
        String password_hash = input.nextLine();
        System.out.println("Input 'full_name': ");
        String full_name = input.nextLine();
        System.out.println("Input 'country': ");
        String country = input.nextLine();
        System.out.println("Input 'email': ");
        String email = input.nextLine();

        User user = new User(null, password_hash, full_name,country,email);

        try {
            userController.create(user);
            System.out.println("Successfully created");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t create");
        }
    }
    private void updateUser() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'password_hash': ");
        String password_hash = input.nextLine();
        System.out.println("Input 'full_name': ");
        String full_name = input.nextLine();
        System.out.println("Input 'country': ");
        String country = input.nextLine();
        System.out.println("Input 'email': ");
        String email = input.nextLine();

        User user = new User(null, password_hash, full_name,country,email);

        try {
            userController.update(id,user);
            System.out.println("Successfully updated");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t update");
        }
    }
    private void deleteUser() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        try {
            userController.delete(id);
            System.out.println("Successfully deleted");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t delete");
        }
    }
    private void findUserById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        try {
            Optional<User> user= userController.findById(id);
            System.out.println(user);
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t find");
        }
    }
    private void findAllUsers() {
        System.out.println("Table: User");
        List<User> all= userController.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }
    private void findAllUsersOfApp() {
        System.out.println("Input 'app_name': ");
        String appName = input.nextLine();

        try {
            List<User> users= userController.getUsersByApp(appName);
            for(User user : users){
                System.out.println(user);
            }
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t find");
        }
    }

    // -------------------------------------Download------------------------
    private void createDownload(){
        System.out.println("Input 'amount': ");
        Integer amount = Integer.valueOf(input.nextLine());
        System.out.println("Input 'total_price': ");
        Float total_price = Float.valueOf(input.nextLine());
        System.out.println("Input 'user_id': ");
        Integer user_id = Integer.valueOf(input.nextLine());

        Download download = new Download(null, amount, total_price,user_id);

        try {
            downloadController.create(download);
            System.out.println("Successfully created");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t create");
        }
    }
    private void updateDownload() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'amount': ");
        Integer amount = Integer.valueOf(input.nextLine());
        System.out.println("Input new 'total_price': ");
        Float total_price = Float.valueOf(input.nextLine());
        System.out.println("Input new 'user_id': ");
        Integer user_id = Integer.valueOf(input.nextLine());

        Download download = new Download(null, amount, total_price,user_id);

        try {
            downloadController.update(id,download);
            System.out.println("Successfully updated");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t update");
        }
    }
    private void deleteDownload() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        try {
            downloadController.delete(id);
            System.out.println("Successfully deleted");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t delete");
        }
    }
    private void findDownloadById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        try {
            Optional<Download> download= downloadController.findById(id);
            System.out.println(download);
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t find");
        }
    }
    private void findAllDownloads() {
        System.out.println("Table: Download");
        List<Download> all= downloadController.findAll();
        for (Download download : all) {
            System.out.println(download);
        }
    }

    // -------------------------------------Feedback------------------------
    private void createFeedback(){
        System.out.println("Input 'description': ");
        String description = input.nextLine();
        System.out.println("Input 'created_date': ");
        String created_date = input.nextLine();
        System.out.println("Input 'rate': ");
        Float rate = Float.valueOf(input.nextLine());
        System.out.println("Input 'user_id': ");
        Integer user_id = Integer.valueOf(input.nextLine());
        System.out.println("Input 'app_id': ");
        Integer app_id = Integer.valueOf(input.nextLine());

        Feedback feedback = new Feedback(null, description, created_date,rate,user_id,app_id);

        try {
            feedbackController.create(feedback);
            System.out.println("Successfully created");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t create");
        }
    }
    private void updateFeedback() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'description': ");
        String description = input.nextLine();
        System.out.println("Input 'created_date': ");
        String created_date = input.nextLine();
        System.out.println("Input 'rate': ");
        Float rate = Float.valueOf(input.nextLine());
        System.out.println("Input 'user_id': ");
        Integer user_id = Integer.valueOf(input.nextLine());
        System.out.println("Input 'app_id': ");
        Integer app_id = Integer.valueOf(input.nextLine());

        Feedback feedback = new Feedback(null, description, created_date,rate,user_id,app_id);

        try {
            feedbackController.update(id,feedback);
            System.out.println("Successfully updated");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t update");
        }
    }
    private void deleteFeedback() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        try {
            feedbackController.delete(id);
            System.out.println("Successfully deleted");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t delete");
        }
    }
    private void findFeedbackById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        try {
            Optional<Feedback> feedback= feedbackController.findById(id);
            System.out.println(feedback);
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t find");
        }
    }
    private void findAllFeedbacks() {
        System.out.println("Table: Feedback");
        List<Feedback> all= feedbackController.findAll();
        for (Feedback feedback : all) {
            System.out.println(feedback);
        }
    }
    private void findAllFeedbacksByUser() {
        System.out.println("Input 'user_name': ");
        String name = input.nextLine();

        try {
            Optional<List<Feedback>> feedbacks= feedbackController.getAllFeedbacksByUserName(name);
            System.out.println(feedbacks.orElse(List.of()));
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t find");
        }
    }

    //------------------------------------Show-------------------------------

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }
    private void outputSubMenu(String fig) {

        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }
    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!keyMenu.equals("Q"));
    }

}
