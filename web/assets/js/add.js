const image = document.getElementById("image-product");
document.getElementById("im-product").addEventListener("change", function (e) {
  image.src = URL.createObjectURL(e.target.files[0]);
});
//const price = document.getElementById("price-input");
//const discount = document.getElementById("discount-input");
//document.querySelector(".add-form").addEventListener("submit", function (e) {
//  e.preventDefault();
//  console.log(price.value);
//  if (!/^\d+$/.test(price.value)) {
//    alert("Bạn phải điền số vào đây vào ô giá sản phẩm");
//  }
//  if (
//    !(
//      /^\d+$/.test(discount.value) &&
//      discount.value <= 100 &&
//      discount.value > 0
//    )
//  ) {
//    alert("Bạn phải điền số  lớn hơn 0 và nhỏ hơn 100 vào ô discount");
//  }
//});
