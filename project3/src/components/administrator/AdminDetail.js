import React from 'react';
import Trainer from '../trainers/Trainer'
import './administrator.css'
import {Link} from 'react-router-dom';
import Request from '../../helpers/request';


const AdminDetail = ({trainers, administrator}) => {

    if(!administrator){
        return <p>
            Please login
        </p>
    }

    const update = function(administrator){
        const request = new Request();
        const url = "/administrators/" + administrator.id;
        request.patch(url, administrator)
        .then(() => window.location = "/administrators")
    }

    const handleDelete = function(id){
        const request = new Request()
        const url = "/trainers/" + id
        request.delete(url)
        .then(() => window.location = "/administrators/admin")
    }

    const deleteTrainer = function(trainer){
        handleDelete(trainer.id)
    }

    const trainerNodes = trainers.map((trainer, index) => {
        return(
        <li key={index} className="administrator-trainer-item">
	        <div className="administrator-trainer-preview">
	            <Trainer trainer={trainer} />
                <button onClick={() => deleteTrainer(trainer)}>Delete</button>
	        </div>
	    </li>
        )
    })

    const loggOut = function(){
        administrator.loggedIn = false;
        update(administrator)
    }

    const createUrl = "/administrators/new"
    return(
        
        <>
            
            <div className="admin-view">
                <Link to = {createUrl}><button className="administrator-add-trainer">Add a new Trainer </button></Link>

                <button onClick={loggOut}>Log out</button>
                <div className="administrator-trainer-nodes">
                    {trainerNodes}
                </div>
            </div>
            
            
        </>
    )
}

export default AdminDetail;
