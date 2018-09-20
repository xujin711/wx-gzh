package msb.wxgzh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "proper")
public class Proper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "proper_id")
    private Long ProperId;
    @Column(name = "username")
    private String username;
    @Column(name = "sex")
    private String sex;



}
