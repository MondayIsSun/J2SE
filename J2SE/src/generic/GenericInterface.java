package generic;

public interface GenericInterface<T> {

	// 接口当中的成员属性默认是public static final的
	// T name = "admin";
	String name = "admin";

	// Cannot make a static reference to the non-static type T
	// Java编译器把泛型理解为：non-static type T(不是静态类型)

	// 理解好为什么泛型是与static矛盾的
	// 在对象当中的static是指公用的意思
	// 对于公用的成员属性或者方法如果你使用了泛型那么你自己想想后果
	// 后果是这些公用的东西有很多变种，那么这怎么会是公用的呢？
	// 泛型是为了代码安全灵活为目的的

	// 泛型是编译时的东西

}
