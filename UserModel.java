import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserModel {
    private String firstName;
    private String lastName;
    private String middleName;
    private Date birthDate;
    private long phoneNumber;
    private char gender;

    public UserModel(String firstName,
            String lastName,
            String middleName,
            Date birthDate,
            long phoneNumber,
            char gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String formattedBirthDate = dateFormat.format(this.getBirthDate());
        return "<" + firstName + "><"
                + lastName + "><"
                + middleName + "><"
                + formattedBirthDate + "> <"
                + phoneNumber + "><"
                + gender + ">";
    }

    public UserModel(String user) {
        this.setUserModel(user);
    }

    private void setUserModel(String user) {
        String[] arrayUser = user.split(" ");
        if (arrayUser.length < 6) {
            throw new DataFormatException("Ошибка ввода количества данных! Введено меньше данных, чем требуется.");
        }

        if (arrayUser.length > 6) {
            throw new DataFormatException("Ошибка ввода количества данных! Введено больше данных, чем требуется.");
        }

        this.firstName = arrayUser[0];
        this.lastName = arrayUser[1];
        this.middleName = arrayUser[2];

        SimpleDateFormat parseDate = new SimpleDateFormat("dd.MM.yyyy");
        try {
            this.birthDate = parseDate.parse(arrayUser[3]);
        } catch (ParseException e) {
            throw new DataFormatException(
                    "Ошибка ввода даты рождения \"" + arrayUser[3] + "\" Введите в формате dd.mm.yyy.", e);
        }

        try {
            this.phoneNumber = Long.parseUnsignedLong(arrayUser[4]);
        } catch (NumberFormatException e) {
            throw new DataFormatException(
                    "Ошибка ввода номера телефона \"" + arrayUser[4] + "\" Введите в числовом формате.", e);
        }

        if (arrayUser[5].length() != 1 || (arrayUser[5].charAt(0) != 'm' && arrayUser[5].charAt(0) != 'f')) {
            throw new DataFormatException("Ошибка ввода пола \"" + arrayUser[5] + "\" Введите f или m.");
        }
        this.gender = arrayUser[5].charAt(0);
    }

}
