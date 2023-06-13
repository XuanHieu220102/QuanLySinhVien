<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ALL students</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div style="background-color: aqua; padding: 30px;">
        <h1 class="text-center" style="color: black;">QUẢN LÝ SINH VIÊN</h1>        
    </div>

    <div class="container" style="padding: 50px 0px;">
            <form method="get" th:action = "@{/}">
                <div class="form-group">
                        <label for="exampleFormControlSelect1">SORT BY</label>
                        <select name="sort_by" class="form-control">
                          <option value = "id">Mặc định</option>
                          <option value = "name">NAME</option>
                          <option value = "email">EMAIL</option>
                          <option value = "lop">CLASS</option>
                        </select>
                        <label for="labe1" style="padding-top: 5px;">SORT DIRECTION</label>
                        <select name="sort_direction" class="form-control">
                            <option value = "asc">Tăng dần</option>
                            <option value = "desc">Giảm dần</option>
                        </select>
                </div>
                <div>
                    <button name = "btnSubmit" type="submit" class="btn btn-success" >Submit</button>
                    <button name = "btnReset" type="reset" class="btn btn-danger" >Reset</button>
                </div>
            </form>

            <div>
                <label for="labelSearch1" style="padding-top: 50px;">Search student by name</label>
                <form th:action="@{/searchName}" method="post">
                    <div class="input-group">
                        <span class="input-group-text">USERNAME</span>
                        <input type="text" name="username" class="form-control" aria-label="USER NAME" >
                        <button type="submit" class="btn btn-success">Submit</button>
                        <button type="reset" class="btn btn-danger" >Reset</button>
                    </div>
                </form>
            </div>
            <div>
                <label for="labelSearch2" style="padding-top: 10px;">Search student by class</label>
                <form th:action="@{/searchClass}" method="post">
                    <div class="input-group">
                        <span class="input-group-text">CLASS</span>
                        <input type="text" name="class" class="form-control" aria-label="CLASS" >
                        <button type="submit" class="btn btn-success">Submit</button>
                        <button type="reset" class="btn btn-danger" >Reset</button>
                    </div>
                </form>
            </div>
        
        <div class="p-5">
            <h1 class="text-center">All students</h1>
        </div>
        <div>
                        <button class="btn btn-outline-danger">
                            <a th:href="@{/add}">ADD STUDENT</a>
                        </button>
        </div>
        <table class="table table-striped">
            <thead>
              <tr>
                <th scope="col">ID</th>
                <th scope="col">USERNAME</th>
                <th scope="col">EMAIL</th>
                <th scope="col">CLASS</th>
                <th scope="col">KHOA</th>
                <th scope="col"></th>
              </tr>
            </thead>
            <tbody>
                <tr th:each = "student: ${students}">
                    <td th:text = "${student.id}"></td>
                    <td th:text = "${student.name}"></td>
                    <td th:text = "${student.email}"></td>
                    <td th:text = "${student.lop}"></td>
                    <td th:text = "${student.khoa}"></td>
                    <td>
                        <button class="btn btn-danger">
                            <a th:href="@{/delete/{id}(id = ${student.id})}" style="color: #fff;">DELETE</a>
                        </button>
                        <button class="btn btn-success">
                            <a th:href="@{/update/{id}(id = ${student.id})} " style="color: #fff;">UPDATE</a>
                        </button>
                    </td>
                </tr>
            </tbody>
          </table>
    </div>
</body>
</html>