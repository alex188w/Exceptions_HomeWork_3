public class Controller {
    // UserModel user = new UserModel(null);

    public static void onClick() {
        while (true) {
            String key = View.inputData("Нажмите: \n"
                    + "1 - просмотреть информацию о пользователе из файла\n"
                    + "2 - добавить файл с информацией о пользователе\n"
                    + "Любой другой символ - выход из программы\n");
            switch (key) {
                case "1":
                    String middleName = View
                            .inputData("Введите фамилию пользователя, информацию о котором хотите посмотреть:");                    
                    View.loadFromFile(middleName);
                    break;
                case "2":
                    UserModel user = new UserModel(View.inputData(
                            "Введите свои данные через пробел:\nФамилия Имя Отчество Дата рождения(dd.mm.yyyy) Телефон(в числовом формате) Пол(f/m)\n"));
                    View.saveFromFile(user);
                    System.out.println("Информация о пользователе добавлена в файл.");
                    break;
                default:
                    System.out.println("Выход из программы");
                    return;
            }
        }
    }
}
