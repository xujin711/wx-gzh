package msb.wxgzh.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserType {
    private Long id;
    private String username;
    private String memo;
    private Long balance;
    private Long title;

}