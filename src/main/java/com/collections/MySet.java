package com.collections;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MySet<E> implements Set<E>
{
    private Map<E, E> delegate = new LinkedHashMap<>();

    /**
     *
     * @return
     * @see java.util.Set#size()
     *
     */
    public int size()
    {
        return delegate.size();
    }

    /**
     *
     * @return
     * @see java.util.Set#isEmpty()
     *
     */
    public boolean isEmpty()
    {
        return delegate.isEmpty();
    }

    /**
     *
     * @param o
     * @return
     * @see java.util.Set#contains(java.lang.Object)
     *
     */
    public boolean contains( Object o )
    {
        return delegate.containsKey( o );
    }

    /**
     *
     * @return
     * @see java.util.Set#iterator()
     *
     */
    public Iterator<E> iterator()
    {
        return delegate.keySet().iterator();
    }

    /**
     *
     * @return
     * @see java.util.Set#toArray()
     *
     */
    public Object[] toArray()
    {
        return delegate.keySet().toArray();
    }

    /**
     *
     * @param a
     * @return
     * @see java.util.Set#toArray(java.lang.Object[])
     *
     */
    public <T> T[] toArray( T[] a )
    {
        return delegate.keySet().toArray( a );
    }

    /**
     *
     * @param e
     * @return
     * @see java.util.Set#add(java.lang.Object)
     *
     */
    public boolean add( E e )
    {
        delegate.put( e, e );
        return true;
    }

    /**
     *
     * @param o
     * @return
     * @see java.util.Set#remove(java.lang.Object)
     *
     */
    public boolean remove( Object o )
    {
        return delegate.remove( o, o );
    }

    /**
     *
     * @param c
     * @return
     * @see java.util.Set#containsAll(java.util.Collection)
     *
     */
    public boolean containsAll( Collection<?> c )
    {
        return delegate.keySet().containsAll( c );
    }

    /**
     *
     * @param c
     * @return
     * @see java.util.Set#addAll(java.util.Collection)
     *
     */
    public boolean addAll( Collection<? extends E> c )
    {
        Map<? extends E, ? extends E> map = c.stream().collect( toMap( identity(), identity() ) );
        delegate.putAll( map );
        return true;
    }

    /**
     *
     * @param c
     * @return
     * @see java.util.Set#retainAll(java.util.Collection)
     *
     */
    public boolean retainAll( Collection<?> c )
    {
        return delegate.keySet().retainAll( c );
    }

    /**
     *
     * @param c
     * @return
     * @see java.util.Set#removeAll(java.util.Collection)
     *
     */
    public boolean removeAll( Collection<?> c )
    {
        c.forEach( e -> delegate.remove( e ) );
        return true;
    }

    /**
     *
     * @see java.util.Set#clear()
     *
     */
    public void clear()
    {
        delegate.clear();
    }

    /**
     *
     * @param o
     * @return
     * @see java.util.Set#equals(java.lang.Object)
     *
     */
    public boolean equals( Object o )
    {
        return delegate.equals( o );
    }

    /**
     *
     * @return
     * @see java.util.Set#hashCode()
     *
     */
    public int hashCode()
    {
        return delegate.hashCode();
    }

    public E get( E o )
    {
        return delegate.get( o );
    }
}
