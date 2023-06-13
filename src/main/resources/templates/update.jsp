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
    <div class="container">
        <div class="p-5">
            <h1 class="text-center">UPDATE STUDENT</h1>
        </div>
        <form th:action = "@{/update/{id}(id = ${student.id})}" th:object="${student}" method="post">
          <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" th:field = "*{name}" placeholder="Enter name" required >
            <small id="nameHelp" class="form-text text-muted">We'll never share your name with anyone else.</small>
          </div>
            <div class="form-group">
              <label for="email">Email address</label>
              <input type="email" class="form-control" id="exampleInputEmail1" th:field = "*{email}" placeholder="Enter email" required>
              <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
          <div class="form-group">
            <label for="class">class</label>
            <input type="text" class="form-control" id="class" th:field = "*{lop}" placeholder="Enter class" required >
             <small id="classHelp" class="form-text text-muted">We'll never share your class with anyone else.</small>
          </div>
          <div class="form-group">
            <label for="khoa">Khoa</label>
            <input type="text" class="form-control" id="khoa" th:field = "*{khoa}" placeholder="Enter department" required >
             <small id="departmentHelp" class="form-text text-muted">We'll never share your department with anyone else.</small>
          </div>
          <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</body>
</html>