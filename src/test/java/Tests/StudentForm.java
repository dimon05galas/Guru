package Tests;


import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class StudentForm {

    @Test

    void studentFormTest() {
        //Открыть ToolsQA
        open("https://demoqa.com/automation-practice-form");
        //Заполнить поле First Name
        $("#firstName").setValue("John");
        //Заполнить поле Last Name
        $("#lastName").setValue("Seena");
        //Заполнить поле Email
        $("#userEmail").setValue("JohnSeena@mail.ru");
        //Отметить Gender
        $(byText("Male")).click();
        //Заполнить поле Mobile
        $("#userNumber").setValue("1111111111");
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
        $("#uploadPicture").uploadFromClasspath("img/John.jpg");
        //Скролим
        $("#submit").scrollTo();
        //Заполнить поле Current address
        $("#currentAddress").setValue("Cannon street. House 3. Apartment 45");
        //Выбрать State и City
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Merrut")).click();
        //Нажимаем Submit
        $("#submit").click();

        //Проверяем

        $x("//td[.='Student Name']").parent().shouldHave(text("John Seena"));
        $x("//td[.='Student Email']").parent().shouldHave(text("JohnSeena@mail.ru"));
        $x("//td[.='Gender']").parent().shouldHave(text("Male"));
        $x("//td[.='Mobile']").parent().shouldHave(text("1111111111"));
        $x("//td[.='Date of Birth']").parent().shouldHave(text("10"));
        $x("//td[.='Subjects']").parent().shouldHave(text("Chemistry"));
        $x("//td[.='Hobbies']").parent().shouldHave(text("Sports, Music"));
        $x("//td[.='Picture']").parent().shouldHave(text("John.jpg"));
        $x("//td[.='Address']").parent().shouldHave(text("Cannon street. House 3. Apartment 45"));
        $x("//td[.='State and City']").parent().shouldHave(text("Uttar Pradesh Merrut"));

    }
}
