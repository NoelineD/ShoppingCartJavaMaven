<div class="container">
        <h2>Create New Product</h2>
        <form action="create-product" method="post">
            <div class="form-group">
                <label for="name">Product Name:</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="category">Category:</label>
                <input type="text" class="form-control" id="category" name="category" required>
            </div>
            <div class="form-group">
                <label for="price">Price:</label>
                <input type="number" class="form-control" id="price" name="price" required>
            </div>
            <div class="form-group">
                <label for="image">Image URL:</label>
                <input type="text" class="form-control" id="image" name="image" required>
            </div>
            <button type="submit" class="btn btn-primary">Create Product</button>
        </form>
    </div>

    <%@ include file="includes/footer.jsp" %>
</body>
</html>