package com.challenges;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

enum Color
{
    RED, GREEN
}

abstract class Tree
{
    private int   value;
    private Color color;
    private int   depth;

    public Tree( int value, Color color, int depth )
    {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue()
    {
        return value;
    }

    public Color getColor()
    {
        return color;
    }

    public int getDepth()
    {
        return depth;
    }

    public abstract void accept( TreeVis visitor );
}

class TreeNode extends Tree
{
    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode( int value, Color color, int depth )
    {
        super( value, color, depth );
    }

    public void accept( TreeVis visitor )
    {
        visitor.visitNode( this );

        for ( Tree child : children )
        {
            child.accept( visitor );
        }
    }

    public void addChild( Tree child )
    {
        children.add( child );
    }
}

class TreeLeaf extends Tree
{
    public TreeLeaf( int value, Color color, int depth )
    {
        super( value, color, depth );
    }

    public void accept( TreeVis visitor )
    {
        visitor.visitLeaf( this );
    }
}

abstract class TreeVis
{
    public abstract int getResult();

    public abstract void visitNode( TreeNode node );

    public abstract void visitLeaf( TreeLeaf leaf );

}

class SumInLeavesVisitor extends TreeVis
{
    private int sum = 0;

    public int getResult()
    {
        return sum;
    }

    public void visitNode( TreeNode node )
    {
        // do nothing
    }

    public void visitLeaf( TreeLeaf leaf )
    {
        sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis
{
    private int       product = 1;
    private final int mod     = 1000000007;

    public int getResult()
    {
        return product;
    }

    private void visit( Tree node )
    {
        if ( node.getColor().equals( Color.RED ) )
        {
            product = ( product * node.getValue() ) % mod;
        }
    }

    public void visitNode( TreeNode node )
    {
        visit( node );
    }

    public void visitLeaf( TreeLeaf leaf )
    {
        visit( leaf );
    }
}

class FancyVisitor extends TreeVis
{
    private int nonLeafSum    = 0;
    private int greenNodesSum = 0;

    public int getResult()
    {
        return Math.abs( nonLeafSum - greenNodesSum );
    }

    public void visitNode( TreeNode node )
    {
        if ( node.getDepth() % 2 == 0 )
        {
            nonLeafSum += node.getValue();
        }
        
        if ( node.getColor().equals( Color.GREEN ) )
        {
            greenNodesSum += node.getValue();
        }
    }

    public void visitLeaf( TreeLeaf leaf )
    {
        if ( leaf.getColor().equals( Color.GREEN ) )
        {
            greenNodesSum += leaf.getValue();
        }
    }
}

public class VisitorPattern
{
    public static Tree solve()
    {
        Scanner in = new Scanner( System.in );
        int n = Integer.parseInt( in.nextLine() );

        String valuesString = in.nextLine();
        String[] valuesArray = valuesString.split( " " );

        String colorsString = in.nextLine();
        String[] colorsArray = colorsString.split( " " );

        Tree root =
                new TreeNode( Integer.parseInt( valuesArray[0] ),
                        colorsArray[0].equals( "0" ) ? Color.RED : Color.GREEN, 0 );

        Tree[] nodes = new Tree[n];
        nodes[0] = root;

        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> internalNodes = new HashSet<>();

        for ( int i = 0; i < n - 1; i++ )
        {
            int source = in.nextInt();
            int target = in.nextInt();
            queue.offer( source );
            queue.offer( target );
            internalNodes.add( source );
        }

        in.close();

        while ( !queue.isEmpty() )
        {
            int source = queue.poll();
            int target = queue.poll();

            if ( nodes[source-1] == null )
            {
                queue.offer( source );
                queue.offer( target );
                continue;
            }

            if ( nodes[target - 1] == null )
            {
                if ( internalNodes.contains( target ) )
                {
                    nodes[target - 1] = new TreeNode( Integer.parseInt( valuesArray[target - 1] ),
                            colorsArray[target - 1].equals( "0" ) ? Color.RED : Color.GREEN,
                            nodes[source - 1].getDepth() + 1 );
                }
                else
                {
                    nodes[target - 1] = new TreeLeaf( Integer.parseInt( valuesArray[target - 1] ),
                            colorsArray[target - 1].equals( "0" ) ? Color.RED : Color.GREEN,
                            nodes[source - 1].getDepth() + 1 );
                }
                TreeNode sourceNode = (TreeNode) nodes[source - 1];
                sourceNode.addChild( nodes[target - 1] );
            }
                
        }
        return root;
    }

    public static Tree solveSimplified()
    {
        Scanner in = new Scanner( System.in );
        int n = in.nextInt();

        int[] values = new int[n];
        for ( int i = 0; i < n; i++ )
        {
            values[i] = in.nextInt();
        }

        Color[] colors = new Color[n];
        for ( int i = 0; i < n; i++ )
        {
            colors[i] = in.next().equals( "0" ) ? Color.RED : Color.GREEN;
        }

        Tree root = new TreeNode( values[0], colors[0], 0 );

        Tree[] nodes = new Tree[n];
        nodes[0] = root;

        Queue<Integer> queue = new ArrayDeque<>( 2 * ( n - 1 ) );
        Set<Integer> internalNodes = new HashSet<>( 2 * ( n - 1 ) );

        for ( int i = 0; i < n - 1; i++ )
        {
            int source = in.nextInt();
            int target = in.nextInt();
            queue.offer( source );
            queue.offer( target );
            internalNodes.add( source );
        }

        in.close();

        while ( !queue.isEmpty() )
        {
            int source = queue.poll();
            int target = queue.poll();

            if ( nodes[source - 1] == null )
            {
                queue.offer( source );
                queue.offer( target );
                continue;
            }

            if ( nodes[target - 1] == null )
            {
                if ( internalNodes.contains( target ) )
                {
                    nodes[target - 1] =
                            new TreeNode( values[target - 1], colors[target - 1], nodes[source - 1].getDepth() + 1 );
                }
                else
                {
                    nodes[target - 1] =
                            new TreeLeaf( values[target - 1], colors[target - 1], nodes[source - 1].getDepth() + 1 );
                }
                TreeNode sourceNode = (TreeNode) nodes[source - 1];
                sourceNode.addChild( nodes[target - 1] );
            }

        }
        return root;
    }

    public static void main( String[] args )
    {
        Tree root = solveSimplified();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept( vis1 );
        root.accept( vis2 );
        root.accept( vis3 );

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println( res1 );
        System.out.println( res2 );
        System.out.println( res3 );
    }

}
