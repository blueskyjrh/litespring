# notes for litespring

### SPR 单一职责原则
- 职责：

		如果有多余一个的动机去改变一个类，这个类就具有多个职责。
		把多个职责耦合在一起，一个变化可能会削弱或者抑制这个类完成其他职责的能力
		
- SPR:
		
		对一个类而言，应该仅有一个引起他变化的原因。

	
----

- BeanFactory面向客户，不能提供修改其内部结构(添加BeanDefinition等)的方法。

- BeanDefinition是内部概念，不应该放到BeanFactory里。

#### 使用BeanFactoryRegistry的好处

1.  XMLBeanDefinitionReader可以获取BeanDefiniton,也可以注册BeanDefinition,但是不知道getBean方法
1.  接口最大化，只希望类知道越少的接口越好。
