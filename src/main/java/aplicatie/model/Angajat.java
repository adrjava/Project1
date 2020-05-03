package aplicatie.model;

import lombok.*;



@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Angajat {
    int id;
    String nume;
    int varsta;
    int departamentiId;
}
