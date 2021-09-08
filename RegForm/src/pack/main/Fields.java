package pack.main;

public enum Fields {
	First_name("First name", "Iм'я"),
	Surname("Surname", "Прiзвище"),	
	Patronymic("Patronymic", "По-батьковi"),
	FIO("Full name", "ПIБ"),
	Login("Login", "Логiн"),
	Group("Group", "Группа"),
	Home_Phone("Home Phone", "Домашнiй телефон"),
	Mobile_Phone("Mobile Phone", "Мобiльний телефон"),
	Mobile_Phone_2("Mobile Phone 2", "Мобiльний телефон 2"),
	Email("Email", "Електронна пошта"),
	Skype("Skype", "Скайп"),
	Address("Address", "Адреса"),
	Date_of_Creation("Date of creation", "Дата створення списку"),
	This_day("Today is", "Сьогоднi");	
	private List<String> fields;
	
	Fields(String...args) {
	    this.fields = List.of(args);
	}
	
	public String value(int local) {
		return fields.get(local);
	}
}

