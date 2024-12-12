using UnityEngine;

public class RotazioneContinua : MonoBehaviour
{
    [SerializeField] private Vector3 _rotation;

    [SerializeField] public GameObject toRotateC;
    [SerializeField] public GameObject toRotateS;

    [SerializeField] public GameObject toRotateCy;
    bool canRotate = false;

    public void StartRotation(){
        canRotate = !canRotate;
    }
    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {
    
    }

    // Update is called once per frame
    void Update()
    {

        if(canRotate){
        toRotateC.transform.Rotate(_rotation * Time.deltaTime);
        toRotateS.transform.Rotate(_rotation * Time.deltaTime);
        toRotateCy.transform.Rotate(_rotation * Time.deltaTime);
        }
        //Ruota l'oggetto lentamente sull'asse Y
    }
}
