package com.cg.cinestar.model;

import com.cg.cinestar.utils.ValidDateUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
@Entity
@Accessors(chain = true)

public class User extends BaseEntity implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private Long id;


    @NotNull(message = "Vui lòng nhập tên đăng nhập!")
    @Size(min = 8, max = 32, message = "Tên đăng nhập chỉ từ 8-32 kí tự!")
    private String username;

    @NotNull(message = "Vui lòng nhập mật khẩu")
    @Size(min = 8, max = 32, message = "Mật khẩu phải gồm 8-32 kí tự!")
    private String password;

    @Column(name = "full_name")
    @NotNull(message = "Vui lòng nhập mật khẩu")
    @Size(min = 5, max = 50, message = "Tên phải gồm 5-50 kí tự!")
    private String fullName;


    @NotBlank(message = "Vui lòng nhập số điện thoại!")
    private String phone;

    @NotNull(message = "Vui lòng nhập email!")
    @Size(min = 5, max = 32, message = "Email phải gồm 5-32 kí tự!")
    @Pattern(regexp = ValidDateUtils.EMAIL_REGEX, message = "Vui lòng nhập đúng đinh dạng email!")
    private String email;

    @NotBlank( message = "Vui lòng nhập địa chỉ!")
    private String address;


    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @OneToOne (targetEntity = Status.class, fetch = FetchType.EAGER)
    private Status status;

    @OneToOne(targetEntity = Role.class,fetch = FetchType.EAGER)
    private Role role;

    @OneToMany(mappedBy = "customer")
    private Set<Invoice> invoices;

    public User(Long id, String username, String password, String fullName, String phone, String email, String address, String dateOfBirth, Status status, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
        this.role = role;
    }

    @Override
    public String toString() {
        return id + " " + username + " " + fullName + " " + phone + " " + email + " " + address + " " + dateOfBirth + " " + status.getStatusName() + " " + role.getName() ;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        String dateOfBirth = user.getDateOfBirth();



        if(dateOfBirth == null || dateOfBirth.equals("")) {
            errors.rejectValue("dateOfBirth","400", "Vui lòng nhập ngày sinh!");
        }else {
            int year = Integer.parseInt(dateOfBirth.substring(0,4));
            int month = Integer.parseInt(dateOfBirth.substring(5,7));
            int day = Integer.parseInt(dateOfBirth.substring(8));

            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());

            int currentYear = calendar.get(Calendar.YEAR);
            int currentMonth = calendar.get(Calendar.MONTH) + 1;
            int currentDay = calendar.get(Calendar.DAY_OF_MONTH);


            if(year > currentYear) {
                errors.rejectValue("dateOfBirth","400", "Ngày sinh không hợp lệ!");
            }else if(year == currentYear) {
                if(month > currentMonth) {
                    errors.rejectValue("dateOfBirth","400", "Ngày sinh không hợp lệ!");
                }else if(month == currentMonth) {
                    if (day > currentDay){
                        errors.rejectValue("dateOfBirth","400", "Ngày sinh không hợp lệ!");
                    }
                }
            }
        }

    }
}
