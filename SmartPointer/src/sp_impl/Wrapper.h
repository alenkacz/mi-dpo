#ifndef WRAPPER_H_
#define WRAPPER_H_

#include "Counted.h"

using namespace std;

template <class T> class Counted;

template <class T>
class Wrapper {
public:
	Wrapper();
	Wrapper(T* ptr);
	~Wrapper();
	Wrapper(const Wrapper<T>& other);

	Wrapper<T>& operator=(const Wrapper<T>& other);

	T* operator->();
	const T* operator->() const;

	bool operator==( const Wrapper<T>& other2);
	bool operator!=(const Wrapper<T>& other);

	bool Null() const {return _counted == 0;}
	void SetNull() { UnBind(); }

private:
	void UnBind();
	Counted<T>* _counted;
};


template <class T>
Wrapper<T>::Wrapper() : _counted(0) {}

template <class T>
Wrapper<T>::Wrapper(T* ptr)
{
	_counted = new Counted<T>(ptr);
	_counted->GetRef();
}

template <class T>
Wrapper<T>::~Wrapper()
{
	UnBind();
}

template <class T>
void Wrapper<T>::UnBind()
{
	if(!Null() && _counted->FreeRef() == 0) {
		delete _counted;
	}

	_counted = 0;
}

template <class T>
const T* Wrapper<T>::operator->() const
{
	 if(Null())
	 {
		 throw -1;
	 }

	 return _counted->_pointer;
}

template <class T>
T* Wrapper<T>::operator->()
{
	 if(Null())
	 {
		 throw -1;
	 }

	 return _counted->_pointer;
}

template<class T>
bool Wrapper<T>::operator==(const Wrapper<T>& other)
{
        return _counted->_pointer == other._counted->_pointer;
}

template<class T>
bool Wrapper<T>::operator!=(const Wrapper<T>& other)
{
        return !(_counted == other);
}

template<class T>
Wrapper<T>::Wrapper(const Wrapper<T>& other)
{
        _counted = other._counted;
        if (!Null())
                _counted->GetRef();
}

template<class T>
Wrapper<T>& Wrapper<T>::operator=(const Wrapper<T>& other)
{
        if (!other.Null())
                other._counted->GetRef();
        UnBind();
        _counted = other._counted;
        return *this;
}

#endif /* WRAPPER_H_ */
