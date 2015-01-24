var arrFactory = function() {
    var arr = new (Java.extend(java.util.ArrayList)) {
        add: function(x) {
            print('Adding ' + x);
            return Java.super(arr).add(x)
        }
    }
    return arr
}

var arr1 = arrFactory()
arr1.add("panda1")
arr1.add("panda2")

var arr2 = arrFactory()
arr2.add("panda3")
arr2.add("panda4")
