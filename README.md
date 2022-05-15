# JPWPforStudents

| Project Details   |      |
| --- | --- | 
| `Authors` | [Pater Bartłomiej]&nbsp;&nbsp;&nbsp;&nbsp; 405114 <br/>[Jaskólski Szymon]&nbsp;&nbsp;&nbsp; 400000
|`College`| AGH University of Science and Technology
|`Subject`| Języki Programowania Wyższego Poziomu

## Przygotowanie do zadań
Wystarczy mieć Jave i pobrać repo, najlepiej do IntelliJ.

## Zadanie 1
Aplikacja posiada dwa tryby wyświetlania fiszek w menu głównym.
Łatwy oraz trudny. Zmodyfikuj program tak, aby wyświetlał tylko
tryb łatwy.
Podpowiedzi: Poszczególne tryby są zawarte w zmiennych easyMode oraz
hardMode. Wybieranie trybu odbywa się w funkcji refresh() w klasie
MainGUI.java

## Zadanie 2
Zmodyfikuj program, aby w menu głównym wyświetlała się nazwa aktualnie
używanego zestawu, zamiasta słowa "brak".
Podpowiedzi: Nazwę zestawu można uzyskać przez funkcję getName() na
obiekcie klasy FlashcardPackage.
Zmienna, w której powinna być umieszczona nazwa aktualnego zestawu, to
currentDeckLabel(za pomocą metody setText())

## Zadanie 3
W klasie Lotto metoda answer  jest niepełna, brakuje kodu, który jest wykonywany kiedy odpowiedź jest poprawna. Przeanalizuj co się dzieje w przeciwnym przypadku i uzupełnił kod. Podpowiedź: chodzi o uzupełnienie kodu po if(isCorrect)

## Zadanie 4
Zrób tak, aby po naciśnięciu "X" w górnym prawym rogu w głównym
menu wyświetlał się komunikat pytający o potwierdzenie wyjścia.
Po kliknięciu "Tak" program powinien się wyłączyć, a po "Nie" nie.
Domyślnie opcje będą w języku angielskim, czyli "Yes" i "No". Należy
zamienić je na język polski.
Podpowiedzi: Kod należy umieścić w funkcji windowClosing w klasie
MainGUI.java. Przydatne mogą okazać się funkcje
JOptionPane.showOptionDialog(), System.exit(0) oraz
setDefaultCloseOperation() użyta na obiekcie JFrame
(użycie setDefaultCloseOperation() odbywa się w funkcji main w 
klasie MainGUI.java, a nie w windowClosing, jak reszta kodu)
