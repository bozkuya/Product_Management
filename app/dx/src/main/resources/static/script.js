document.addEventListener("DOMContentLoaded", function() {

    document.getElementById('addProductForm').addEventListener('submit', function(event) {
      event.preventDefault();
      const product = {
        name: document.getElementById('name').value,
        code: document.getElementById('code').value,
        description: document.getElementById('description').value,
        brand: document.getElementById('brand').value,
        currency: document.getElementById('currency').value,
        price: parseFloat(document.getElementById('price').value),
        stock: parseInt(document.getElementById('stock').value)
      };
      addProduct(product);
    });
  
    // List Current Products
    listProducts();
  });
  
  async function listProducts() {
    const res = await fetch('http://localhost:8080/api/products');
    const data = await res.json();
    let productHTML = '<ul>';
    data.forEach(product => {
      productHTML += `<li>${product.name} - ${product.price} ${product.currency}</li>`;
    });
    productHTML += '</ul>';
    document.getElementById('products').innerHTML = productHTML;
  }
  
  async function addProduct(product) {
    const res = await fetch('http://localhost:8080/api/products', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(product)
    });
    if (res.ok) {
      listProducts();
    }
  }
  function deleteProduct(id) {
    fetch("/api/products/" + id, {
        method: "DELETE",
    })
    .then((response) => {
        if(response.ok) {
            return response.json();
        } else {
            throw new Error('Failed to delete');
        }
    })
    .then((data) => {
        // Refresh the product list
        fetchProducts();
    })
    .catch((error) => console.error(error));
}
async function updateProduct() {
    const id = document.getElementById("updateId").value;
    const field = document.getElementById("updateField").value;
    const value = document.getElementById("updateValue").value;
  
    const updatedProduct = {};
    updatedProduct[field] = value;
  
    const res = await fetch(`http://localhost:8080/api/products/${id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(updatedProduct),
    });
  
    if (res.ok) {
      listProducts();
    } else {
      console.error("Error:", res.statusText);
    }
  }