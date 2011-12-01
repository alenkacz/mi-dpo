#ifndef WRAPPER_H_
#define WRAPPER_H_

#include "Counted.h"

using namespace std;

template <class T>
class Wrapper {
public:
	Wrapper();
	Wrapper(T* ptr);
	~Wrapper();
	//Wrapper(const Wrapper<T>& other);

	//Wrapper<T>& operator=(const Wrapper<T>& other);

	T* operator->();
	const T* operator->() const;

	//friend bool operator==(const Wrapper<T>& other, const Wrapper<T>& other2);

	bool Null() const {return _counted == 0;}
	void SetNull() { UnBind(); }

private:
	void UnBind();
	Counted<T>* _counted;
};

#endif /* WRAPPER_H_ */
