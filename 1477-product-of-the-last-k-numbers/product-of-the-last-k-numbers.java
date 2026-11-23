class ProductOfNumbers {
    
    ArrayList<Integer> preProduct;
    public ProductOfNumbers() {
        preProduct=new ArrayList<>();
        preProduct.add(1);
    }
    
    public void add(int num) {
        if(num==0){
            preProduct=new ArrayList<>();
            preProduct.add(1);
        }
        else{
           preProduct.add(preProduct.get(preProduct.size()-1)*num);

        }
    }
    
    public int getProduct(int k) {
        if(k>=preProduct.size())return 0;
        return preProduct.get(preProduct.size()-1)/preProduct.get(preProduct.size()-1-k);
    }
}



/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */