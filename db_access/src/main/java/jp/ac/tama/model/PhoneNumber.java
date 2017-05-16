package jp.ac.tama.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by YK on 2017/05/16.
 */

@Data
@AllArgsConstructor
public class PhoneNumber {
    private String number;
    private String name;
}
