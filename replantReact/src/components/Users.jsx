import api from "../services/api";
import { useEffect, useState } from "react";

const Users = () => {
    const [users, setUsers] = useState([]);
    const [user, setUser] = useState({
        name: '',
        region: '',
        url: ''
    });

    function getUsers() {
        const options = {
            method: "GET",
            url: "/users",
        };

        api
            .request(options)
            .then((response) => {
                setUsers(response.data);
                console.log(response.data);
            })
            .catch((error) => {
                console.error(error);
            });
    }

    const handleSubmit = (event) => {
        const options = {
            method: "POST",
            url: "/users",
            body: user
        };
        api
            .request(options)
            .then((response) => {
                setUsers(response.data);
                console.log(response.data);
            })
            .catch((error) => {
                console.error(error);
            });
    }

    const handleChange = (event) => {
        setUser({...user,[event.target.name]: event.target.value})
    }

    useEffect(() => {
        getUsers();
    }, []);

    return (
        <div>
            {users.map((user) => (
                <div>
                    <h1 key={user.id}>{user.name}</h1>
                    <span>{user.url}</span><br></br>
                    <span>{user.region}</span>
                </div>
            ))}
            <form onSubmit={handleSubmit}>
                <label>
                    Name: <input type="text" name="name" value={user.name} onChange={handleChange}/>
                </label>
                <label>
                    Region: <input type="text" name="region" value={user.region} onChange={handleChange}/>
                </label>
                <label>
                    Url: <input type="text" name="url" value={user.url} onChange={handleChange}/>
                </label>
                <button type="submit">Enviar</button>
            </form>
        </div>
        
    );
};

export default Users;