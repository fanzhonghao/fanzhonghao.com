/* -----------------------------------
 *  Author:fan
 *  Date:2017.7.21
 * -----------------------------------
 *  Description:
 *    This code allow you make mult-
 *  istage conditions with switch-case
 *  and in this code it is initAll
 *  rather than initAll(), the
 *  statement "window.onload = initAll"
 *  stands for run initAll() after
 *  onload the window.
 *  Besides, in the javaScript id is
 *  unique.
 * ------------------------------------
 */
window.onload = initAll;
function initAll() {
  document.getElementById("Lincoln").onclick = saySomething;
  document.getElementById("Kennedy").onclick = saySomething;
  document.getElementById("Nixon").onclick = saySomething;
}
function saySomething(){
  switch (this.id) {
    case "Lincoln":
      alert("Four score and seven years ago...");
      break;
    case "Kennedy":
        alert("Ask not what your country can do for you...")
      break;
    case "Nixon":
      alert("I am not a crook!");
      break;
    default:
  }
}
