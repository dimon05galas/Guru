package Tests;


import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentFormWithRandom {

    @Test

    void studentFormTest() {

        Faker faker = new Faker();

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                gender = "Male",
                userMobile = faker.number().digits(10),
                picture = "John.jpg",
                state = "Uttar Pradesh",
                city = "Merrut",
                currentAddress = faker.address().fullAddress();

        //Открыть ToolsQA
        open("https://demoqa.com/automation-practice-form");
        //Заполнить поле First Name
        $("#firstName").setValue(firstName);
        //Заполнить поле Last Name
        $("#lastName").setValue(lastName);
        //Заполнить поле Email
        $("#userEmail").setValue(userEmail);
        //Отметить Gender
        $(byText(gender)).click();
        //Заполнить поле Mobile
        $("#userNumber").setValue(userMobile);
        //Выбрать дату
        $("#dateOfBirthInput").click();
        $$(".react-datepicker__day").find(Condition.exactText("10")).click();
        //Заполнить Sebjects
        $("#subjectsInput").setValue("C");
        $("#react-select-2-option-1").click();
        //Отметить хобби
        $(byText("Sports")).click();
        $(byText("Music")).click();
        //Загрузить фото
        $("#uploadPicture").uploadFromClasspath("img/" + picture);
        //Скролим
        $("#submit").scrollTo();
        //Заполнить поле Current address
        $("#currentAddress").setValue(currentAddress);
        //Выбрать State и City
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        //Нажимаем Submit
        $("#submit").click();

        //Проверяем

        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']").parent().shouldHave(text(userEmail));
        $x("//td[text()='Gender']").parent().shouldHave(text("Male"));
        $x("//td[text()='Mobile']").parent().shouldHave(text(userMobile));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text("10"));
        $x("//td[text()='Subjects']").parent().shouldHave(text("Chemistry"));
        $x("//td[text()='Hobbies']").parent().shouldHave(text("Sports, Music"));
        $x("//td[text()='Picture']").parent().shouldHave(text(picture));
        $x("//td[text()='Address']").parent().shouldHave(text(currentAddress));
        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));

    }
}
