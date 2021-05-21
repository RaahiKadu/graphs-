/* 
create 
insert
update 
delete 
ascending
descending
max comparisons 
max height 
*/
#include <iostream>
using namespace std;
class Node
{
private:
    string key;
    string value;
    Node *left;
    Node *right;

public:
    Node()
    {
        left = NULL;
        right = NULL;
    }

    Node(string k, string v)
    {
        key = k;
        value = v;
        left = NULL;
        right = NULL;
    }

    friend class BinarySearchTree;
};

class BinarySearchTree
{

private:
    Node *root;

public:
    BinarySearchTree()
    {
        root = NULL;
    }

    Node *getRoot()
    {
        return root;
    }

    int Search(string k, Node *&node, Node *&parent)
    {
        if (root == NULL)
        {
            cout << "Empty Tree" << endl;
            return -1;
        }

        node = root;
        parent = NULL;

        while (node != NULL)
        {
            if (node->key == k)
            {
                return 1;
            }
            else if (node->key > k)
            {
                parent = node;
                node = node->left;
            }
            else
            {
                parent = node;
                node = node->right;
            }
        }
        return -1;
    }

    void Insert(string k, string val)
    {
        if (root == NULL)
        {
            root = new Node(k, val);
            return;
        }

        Node *node = NULL;
        Node *parent = NULL;

        int s = Search(k, node, parent);

        if (s == -1)
        {
            if (parent->key < k)
            {
                cout << parent->key << ": right " << val << endl;
                parent->right = new Node(k, val);
            }
            else
            {
                cout << parent->key << ": left " << val << endl;
                parent->left = new Node(k, val);
            }
        }
        else
        {
            cout << "Key already Present" << endl;
        }
    }

    void Create()
    {
        char c;
        string k, val;

        while (true)
        {
            cout << "Do you want to insert node (y/n): ";
            cin >> c;

            if (c == 'Y' || c == 'y')
            {
                cout << "Enter Keyword :";
                cin >> k;
                cout << endl;
                cout << "Enter value :";
                cin >> val;
                Insert(k, val);
            }
            else
            {
                cout << "Creation Done!" << endl;
                break;
            }
        }
    }

    void UpdateValue(string k, string val)
    {

        if (root == NULL)
        {
            cout << "Empty tree" << endl;
            return;
        }

        Node *node = NULL;
        Node *parent = NULL;

        int s = Search(k, node, parent);
        if (s == -1)
        {
            cout << "Key not Present" << endl;
            return;
        }

        node->value = val;
    }

    void Ascending(Node *curr)
    {
        if (root == NULL)
        {
            cout << "Empty Tree" << endl;
            return;
        }

        if (curr == NULL)
            return;

        Ascending(curr->left);
        cout << curr->key << " : " << curr->value << endl;
        Ascending(curr->right);
    }

    void Descending(Node *curr)
    {
        if (root == NULL)
        {
            cout << "Empty Tree" << endl;
            return;
        }

        if (curr == NULL)
            return;

        Descending(curr->right);
        cout << curr->key << " : " << curr->value << endl;
        Descending(curr->left);
    }

    int MaxComparison(string k, Node *cur_Node, int count)
    {
        if (root == NULL)
        {
            cout << "Empty Tree" << endl;
            return 0;
        }
        if (cur_Node == NULL)
        {
            return 0;
        }
        if (cur_Node->key == k)
        {
            return count;
        }
        int Subtree_left = MaxComparison(k, cur_Node->left, count + 1);
        int Subtree_right = MaxComparison(k, cur_Node->right, count + 1);
        return (Subtree_left != 0  ? Subtree_left : Subtree_right);
    }

    void DeleteKey(string k)
    {
        Node *node = new Node;
        Node *par = new Node;
        Search(k, node, par);
        if (node->right != NULL && node->left != NULL)
        {
            par = node;
            Node *Inoder_succ = node->right;
            while (Inoder_succ->left != NULL)
            {
                par = Inoder_succ;
                Inoder_succ = Inoder_succ->left;
            }
            node->key = Inoder_succ->key;
            node->value = Inoder_succ->value;
            node = Inoder_succ;
        }
        if (node->left == NULL && node->right == NULL)
        {
            if (par->left == node)
                par->left = NULL;
            else
                par->right = NULL;
        }
        else if (node->left != NULL && node->right == NULL)
        {
            if (par->left == node)
                par->left = node->left;
            else
                par->right = node->left;
        }
        else if (node->right != NULL && node->left == NULL)
        {
            if (par->left == node)
                par->left = node->right;
            else
                par->right = node->right;
        }
        cout << "Deleted "<< endl;
        delete node;
    }

    int Maxheight(Node *root){
        int lheight,rheight;
        if (root == NULL){
            return 0;
        }
        rheight = Maxheight(root->left);
        lheight = Maxheight(root->left);
        return max(rheight, lheight)+1;
    }

};

int main()
{

    BinarySearchTree bst;

    while (true)
    {
        int option;
        cout << "\nEnter the option:\n1.Create Binary Search Tree \n2.Insert \n3.Update Key \n4.Delete Key \n5.Ascending Order \n6.Descending Order\n7.Maximum Comparisons\n8.Maximum height\n9.Exit\n>>>";
        cin >> option;
        cout << endl;
        if (option == 1)
        {
            bst.Create();
        }
        else if (option == 2)
        {
            string k, val;
            cout << "Enter Key: ";
            cin >> k;
            cout << "Enter Value: ";
            cin >> val;
            bst.Insert(k, val);
        }
        else if (option == 3)
        {
            string k, val;
            cout << "Enter Key: ";
            cin >> k;
            cout << "Enter Value: ";
            cin >> val;
            bst.UpdateValue(k, val);
        }
        else if (option == 4)
        {
            string k;
            cout << "Enter Key to Be Deleted: ";
            cin >> k;
            bst.DeleteKey(k);
            cout<< k <<"is deleted and replaced by"<<endl;
        }
        else if (option == 5)
        {
            cout << "Ascending Dictionary:\n";
            bst.Ascending(bst.getRoot());
        }
        else if (option == 6)
        {
            cout << "Descending Dictionary:\n";
            bst.Descending(bst.getRoot());
        }
        else if (option == 7)
        {
            string s;
            cout << "Enter keyword to find max no of comparisions: ";
            cin >> s;
            cout << "Maximum Number of Comparison: " << bst.MaxComparison(s, bst.getRoot(), 0) << endl;
        }
        else if (option == 8)
        {
            cout<<"Height of this binary tree :"<<endl;
            bst.Maxheight(bst.getRoot());
        }
        else
        {
            cout<<"Thank You"<<endl;
            break;
        }
    }

    return 0;
}


/*
void Insert(Node *root, Node *t)
{
        if (t->data < root->data)
        {
            root->lchild = t;
            t->lchild = root->lchild;
            t->rchild = root;
            root->lbit = 1;
        }
        else if (t->data > root->data)
        {
            root->rchild = t;
            t->lchild = root;
            t->rchild = root->rchild;
            root->rbit = 1;
        }
        else
        {
            cout << "Insertion Failed" << endl;
        }
}



    TBT tbt;

    while (true)
    {
        int option;

        cout << "1.Create Threaded Binary Tree\n2.Inorder Traversal\n3.Preorder Traversal\n4.Delete element in TBT\n5.Exit" << endl;
        cin >> option;
        cout << endl;
        if (option == 1)
        {
            tbt.create();
        }
        else if (option == 2)
        {
            cout << "Inorder Traversal :";
        }
        else if (option == 3)
        {
            cout << "Preorder Traversal :";
        }
        else if (option == 4)
        {
            int s;
            cout << "Enter element to be deleted :";
            cin >> s;
        }
        else
        {
            cout << "Thank you";
            break;
        }
    }
*/

/*
class TBT
{
    Node *root;
    Node *t;
    Node *head;

public:
    TBT()
    {
        root = NULL;
    }

    void create()
    {
        char ch;
        Node *root, *t;

        t = new Node;
        cout << "Enter Data:";
        cin >> t->data;
        t->lchild = NULL;
        t->rchild = NULL;
        t->lbit = 0;
        t->rbit = 0;
        while (true)
        {

            if (root == NULL)
            {
                root = t;
                head = new Node;
                head->data = 111;
                head->rchild = head;
                head->rbit = 1;
                head->lchild = root;
                head->lbit = 1;
                root->lchild = head;
                root->rchild = head;
            }

            cout << "Do you want to insert node(y/n) ?";
            cin >> ch;

            if (ch == 'y')
            {
                /*Insert(root,t);
            }
            else
            {
                cout << "Creation Done." << endl;
            }
        }
    }
};

    void Insert(Node *root, Node *t)
    {
        if (t->data < root->data)
        {
            root->lchild = t;
            t->lchild = root->lchild;
            t->rchild = root;
            root->lbit = 1;
        }
        else if (t->data > root->data)
        {
            root->rchild = t;
            t->lchild = root;
            t->rchild = root->rchild;
            root->rbit = 1;
        }
        else
        {
            cout << "Insertion Failed" << endl;
        }
    }
*/
