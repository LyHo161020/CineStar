class App {
    static DOMAIN = location.origin;
    static BASE_URL = this.DOMAIN + "/api";
    static BASE_URL_MOVIE = this.DOMAIN + "/api/movies";
    static BASE_URL_CATEGORY = this.DOMAIN + "/api/categories";

    static ERROR_400 = "Giao dịch không thành công, vui lòng kiểm tra lại dữ liệu.";
    static ERROR_401 = "Bạn chưa đăng nhập! Vui lòng đăng nhập!";
    static ERROR_403 = "Thực hiện thất bại! Tài khoản của bạn không có quyền thực hiện chức năng này.";
    static ERROR_404 = "An error occurred. Please try again later!";
    static ERROR_500 = "Lưu dữ liệu không thành công, vui lòng liên hệ quản trị hệ thống.";

    static UNLOCK_SUCCESS = "Unlock user success!";
    static BLOCK_SUCCESS = "Block user success!";
    static CREATE_SUCCESS = "Create user success!";
    static UPDATE_SUCCESS = "Update user success!";

    static SweetAlert = class {

        static showConfirmDelete(mess, ok, notOk) {
            return Swal.fire({
                icon: 'warning',
                text: mess,
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: ok,
                cancelButtonText: notOk,
            })
        }

        static showSuspendConfirmDialogCustomer() {
            return Swal.fire({
                icon: 'warning',
                text: 'Bạn có chắc muốn khoá tài khoản này không?',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Đồng ý!',
                cancelButtonText: 'Huỷ',
            })
        }

        static showUnlockConfirmDialogCustomer() {
            return Swal.fire({
                icon: 'warning',
                text: 'Bạn có chắc muốn mở khoá tài khoản này không?',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Đồng ý!',
                cancelButtonText: 'Huỷ',
            })
        }

        static showSuccessAlert(t) {
            Swal.fire({
                icon: 'success',
                title: t,
                position: 'top-end',
                showConfirmButton: false,
                timer: 2500
            })
        }

        static showErrorAlert(t) {
            Swal.fire({
                icon: 'error',
                title: 'Warning',
                text: t,
            })
        }
    }

    static IziToast = class {
        static showSuccessAlert(t) {
            iziToast.success({
                title: 'OK',
                position: 'topRight',
                timeout: 2500,
                message: t
            });
        }

        static showErrorAlert(t) {
            iziToast.error({
                title: 'Error',
                position: 'topRight',
                timeout: 3500,
                message: t
            });
        }
    }

    static drawRowMovie(id, title, image, premiereDate, showDuration, director, actor, language) {
        let str = `
            <tr id="tr_${id}" >
                <td>
                    <b>${id}</b>
                </td>
                <td>
                    ${title}
                </td>
                <td>
                    <img src="${image}" class="rounded mx-auto d-block img-thumbnail">
                </td>
                <td>
                    ${premiereDate}
                </td>
                <td>
                    ${showDuration}
                </td>
                <td id="tdCategory_${id}">
<!--                    <span class="badge badge-secondary">Low</span>-->
<!--                    <span class="badge badge-success">Open</span>-->
                </td>
                <td>
                    ${director}
                </td>
                <td>
                     ${actor}
                </td>
                <td>
                    ${language}
                </td>
                <td>
                    <button type="button" id="btn_edit_movie_${id}" data-toggle="modal" data-target="#md_update_movie" class="btn btn-primary btn-sm waves-effect waves-light btn_edit_movie mb-1">
                        <i class="fas fa-edit"></i></i>
                    </button>
                    <button type="button" id="btn_delete_movie_${id}" data-toggle="modal" class="btn btn-warning btn-sm waves-effect waves-light btn_delete_movie">
                        <i class="fas fa-ban"></i></i>
                    </button>
                </td>
              
        `;

        return str;
    }

    static drawCheckboxCategory(id, category){
        let str = `
            <div class="col-lg-4">
                <div class="custom-control custom-checkbox custom-checkbox-info mb-3">
                    <input type="checkbox" class="custom-control-input category" id="category_${id}" name="${category}">
                    <label class="custom-control-label" for="category_${id}">${category}</label>
                </div>    
            </div>
                
        `;
        return str;
    }
    static drawCheckboxCategoryUp(id, category){
        let str = `
            <div class="col-lg-4">
                <div class="custom-control custom-checkbox custom-checkbox-info mb-3">
                    <input type="checkbox" class="custom-control-input categoryUp ${category}" id="categoryUp_${id}" name="${category}">
                    <label class="custom-control-label" for="categoryUp_${id}">${category}</label>
                </div>    
            </div>
                
        `;
        return str;
    }

}

class User {
    constructor(id, userName, password, fullName, phone, email, address,dateOfBirth, status, role) {
        this.id = id;
        this.username = userName;
        this.password = password;
        this.fullName = fullName;
        this.phone = phone;

        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
        this.role = role;
    }
}

class Status {
    constructor(id, status) {
        this.id = id;
        this.statusName = status;
    }
}

class Role {
    constructor(id, code, name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }
}


class Movie {
    constructor(id, title, premiereDate, showDuration, categories, director, actor, language, description) {
        this.id = id;
        this.title = title;
        this.premiereDate = premiereDate;
        this.showDuration = showDuration;
        this.categories = categories;
        this.director = director;
        this.actor = actor;
        this.language = language;
        this.description = description;
    }
}
class Category {
    constructor(id, name) {
        this.id = id;
        this.name = name;
    }
}


