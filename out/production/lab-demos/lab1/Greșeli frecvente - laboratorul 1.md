# Greșeli frecvente - lab 1
## Scrierea instrucțiunilor în clase
În Java, spre deosebire de C, instrucțiunile trebuie să fie scrise în metode (adică funcții), iar metodele trebuie să fie implementate în clase.

Așa nu:
- exemplul 1
```java
public class SomeClass {
	System.out.println("Nu scriem println in afara metodelor"); 
	// dar o putem face in blocuri de cod, o sa vedem mai tarziu
	
	for (int i = 0; i < 10; i++) {
		System.out.println("Nu scriem for in afara metodelor");
	}
}
```
- exemplul 2
```java
int a = 69; // nu declaram variabile in afara claselor - in C++ se poate
System.out.println("Nu scriem println in afara claselor");
for (int i = 0; i < 10; i++) {
	System.out.println("Nu scriem for in afara claselor");
}
public class SomeClass {
}
```
- exemplul 3
```java
void doStuff() {
	System.out.println("Nu scriem metode in afara claselor");
}

public class SomeClass {

}
```

Așa da:
```java
public class MyClass {
	int a = 69; // a este un membru al clasei MyClass, putem face direct initializarea aici
	
	void doStuff() {
		System.out.println("folosim println in metoda");
		a++;
		for (int i = 0; i < 10; i++) {
			a += 2;
			System.out.println("punem for in metoda " + a);
		}
	}
}
```

## Semnătura main-ului
În Java, funcția main are următoarea semnătură: `public static void main(String[] args)`, care este echivalent cu `int main (int argc, char** args)`. În Java, funcția main nu returnează nimic (este `void`) și este o funcție / metodă statică (o să vedem despre static în următoarele laboratoare). Este important să păstrăm această semnătură pentru ca să fie recunoscut entry point-ul programului.
## Instanțierea obiectelor și popularea membrilor unui obiect
Când vrem să folosim un obiect, mai întâi il instanțiem (adică îl creăm cu ajutorul keyword-ului `new` - echivalent cu `malloc` din C), apoi după instanțiere putem să îi populăm câmpurile cu informații.
Exemple:
- clasa pe care o instanțiem
```java
public class Student {
	int id;
	String name;
}
```
- așa nu
```java
Student st; // fara instantiere, are valoare default null
st.name = "Malone"; // nu putem pune valoare campului name
// nu are sens sa ne "jucam" cu ceva ce nu exista (obiectul st adica, el nu a fost creat)
// am avea exceptie NullPointerException - echivalentul lui segfault din C
```
- așa da
```java
Student st = new Student(); // am creat obiectul, putem sa ne folosim de el
st.name = "Malone";
```
## Folosirea keyword-ului `private`
După cum știți, câmpurile și membrii care sunt `private` pot fi accesați doar în interiorul clasei din care fac parte.

Pentru a putea totuși accesa membrii privați, folosim metode de tip getter și setter (treaba asta se leagă de conceptele POO).

Exemple:
- clasa pe care o instanțiem
```java
public class Student {
	private int id;
	private String name;
	
	// acum, pentru ca avem membrii private, trebuie sa adaugam metodele getter si setter
	// cu getter obtinem valoarea campului respectiv
	// cu setter modificam valoarea campului respectiv
	
	// getteri
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	// setteri - sunt mereu de tip void, nu avem nevoie sa returnam
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
```
- așa nu
```java
Student st = new Student();
st.name = "Malone"; // eroare, name este private, nu poate fi accesat din afara clasei
int id = st.id; // iarasi eroare, id este private
```
- așa da
```java
Student st = new Student();
st.setName("Malone");
int id = st.getId();
```
## Folosirea array-urilor (mai ales cele de obiecte)
În Java, putem folosi array-uri (impropriu-zis vectori) similar ca în C.

Exemplu - array de 10 numere întregi: `int[] arr = new int[10];` - dimensiune fixă de 10 elemente, new se comportă similar cu malloc-ul din C.

Când construim un array de obiecte, trebuie să avem grijă la popularea array-ului cu obiecte pe care le creăm pe loc, ca în exemplele de mai jos.

Exemple:
- așa da
```java
Student[] arr = new Student[3]; // array de 3 studenti
arr[0] = new Student(); // mai intai punem un obiect Student in pozitia 0, apoi atribuim valori obiectului din pozitia respectiva
arr[0].setName("Malone");
arr[0].setId(69);

Student st = new Student();
st.setName("Decebal");
st.setId(420);
arr[1] = st;

arr[2] = new Student();
arr[2].setName("Mirona");
arr[2].setId(489);
```
- așa nu
```java
Student[] arr = new Student(3); // in acest caz trebuie cu paranteze drepte la marimea array-ului
// Student arr[3]; // nici asa nu merge sa declari in Java, asa cum poti in C
arr[0].setName("Malone"); // vom avea NullPointerException, deoarece nu exista obiectul de tip Student din pozitia 0, nu este creat
arr[0].setId(69);

// codul de mai jos este ok
Student st = new Student();
st.setName("Decebal");
st.setId(420);
arr[1] = st;

arr[2] = new Student();
arr[2].setName("Mirona");
arr[2].setId(489);
```
Este important să alocăm cât avem noi nevoie, nu este ok să aloci memorie pentru 1000 de elemente și să populezi doar cu 50, deoarece, în acest caz, mărimea array-ului va fi 1000. nu 50. În plus, pot apărea probleme (excepția NullPointerException, atunci când încercăm să accesăm un element care nu a fost creat / instanțiat).

Exemplu:
- așa nu:
```java
// noi vrem sa cream un array, in care sa bagam doi studenti

Student[] students = new Student[100]; // gresit, aici trebuia 2 in loc de 100, alocam cat este nevoie
Student st = new Student();
st.setName("Decebal");
st.setId(420);
students[0] = st;

students[1] = new Student();
students[1].setName("Mirona");
students[1].setId(489);

for (int i = 0; i < students.length; i++) {
	System.out.println(students[i].getName()); // la i = 2 o sa crape codul, se va arunca NullPointerException
}
```
- așa da:
```java
// noi vrem sa cream un array, in care sa bagam doi studenti

Student[] students = new Student[2]; // acum e corect
Student st = new Student();
st.setName("Decebal");
st.setId(420);
students[0] = st;

students[1] = new Student();
students[1].setName("Mirona");
students[1].setId(489);

for (int i = 0; i < students.length; i++) {
	System.out.println(students[i].getName());
}
```

## Coding style - nu sunt greșeli, doar indicații de a scrie cod modularizat și ușor de citit
- numele claselor - e indicat să înceapă cu literă mare
- o clasă ar trebui să aibă fișierul ei, în sensul că trebuie să existe o clasă (cu keyword-ul public, într-un fișier .java clasa publică aflată în acel fișier trebuie să aibă acelați nume cu fișierul)
## Compilarea și rularea din linie de comandă
- compilare (mai ales când ai mai multe fișiere .java): `javac *java` - o puteți face țărănește
- rulare - `java Main`, Main fiind numele unei clase unde avem main

Când folosiți pachete, compilați fișierele în folderul cu sursele, apoi rulați executabilul cu main-ul din folderul rădăcină al pachetului. Exemplu: fie pachetul task1, care conține clase, inclusiv clasa cu main. Totul se face în felul următor:
```
javac *java - asta in folderul cu sursele
java task1.Main - asta in folderul radacina al pachetului
```
